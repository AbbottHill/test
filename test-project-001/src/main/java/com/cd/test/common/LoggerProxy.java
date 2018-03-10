package com.cd.test.common;

import lombok.extern.log4j.Log4j2;
import org.apache.oozie.client.OozieClientException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Log4j2
@Component("loggerProxy")
@Aspect
public class LoggerProxy {

    @Pointcut("execution(public * com.cd.test.operation.mytest.controller.TestController.*(..))")
    public void logStart() {
    }

    @Before("logStart()")
    @Async("loggerExecutor")
    public void beforeAdvice() {
        System.out.println("AOP Before. currentThread: " + Thread.currentThread().getName());
    }

    @Async
    public void info(Object info) {
        log.info(info);
    }

    @Async
    public void info(String message) {
        log.info(message);
    }

    @Async
    public void info(Exception e) {
        log.info(e.getMessage(), e);
    }

    @Async
    public void error(Exception e) {
        log.error(e.getMessage(), e);
    }

    private static void submitLoggerJob() throws OozieClientException, InterruptedException
    {
        // get a OozieClient for local Oozie
//        XOozieClient  wc =new AuthOozieClient("http://hadoop7:11000/oozie/");
////       OozieClient wc = new OozieClient("http://hadoop7:11000/oozie/v1/job/");
////       AuthOozieClient wc = new AuthOozieClient("http://hadoop7:11000/oozie/", AuthOozieClient.AuthType.KERBEROS.toString());
//        try {
//            System.out.println(UserGroupInformation.getLoginUser());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // create a workflow job configuration and set the workflow application path
//        Properties conf = wc.createConfiguration();
//        conf.setProperty(OozieClient.APP_PATH, "hdfs://nameservice1/user/oozieweb/oozie-app/oozieweb/workflow/antest2");
//
//        // setting workflow parameters
//        conf.setProperty("jobTracker", "hadoop7:8032");
//        conf.setProperty("nameNode", "hdfs://nameservice1");
////       conf.setProperty("examplesRoot", EXAMPLE_DIR);
//        conf.setProperty("queueName", "cdrapp");
////       conf.setProperty("outputDir", OUTPUT_DIR);
////       conf.setProperty("oozie.wf.rerun.failnodes", "true");
//        conf.setProperty("hdfs.keytab.file", "C:/Program Files (x86)/Java/newhadoop_oozieweb_conf/oozieweb.keytab");
//        conf.setProperty("hdfs.kerberos.principal", "oozieweb");
//        conf.setProperty("mapred.mapper.new-api", "true");
//        conf.setProperty("mapred.reducer.new-api", "true");
//        conf.setProperty("oozie.use.system.libpath", "true");
//
//        // submit and start the workflow job
//        String jobId = wc.run(conf);
//        System.out.println("Workflow job submitted");
//
//        // wait until the workflow job finishes printing the status every 10 seconds
//        while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
//            System.out.println("Workflow job running ...");
//            Thread.sleep(10 * 1000);
//        }
//
//        // print the final status of the workflow job
//        System.out.println("Workflow job completed ...");
//        System.out.println(wc.getJobInfo(jobId));
    }

    @Async
    public void asyncTest() {
        System.out.println("asyncTest. " + Thread.currentThread().getName());
    }
}
    