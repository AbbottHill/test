package com.cd.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
    static Scheduler scheduler = null;

    public static void main(String[] args) {
        try {
            //创建scheduler
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            //定义一个Trigger
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
                    .startNow()//一旦加入scheduler，立即生效
//                    .withSchedule(simpleSchedule() //使用SimpleTrigger
//                            .withIntervalInSeconds(1) //每隔一秒执行一次
//                            .repeatForever()) //一直执行，奔腾到老不停歇
                    .withSchedule(cronSchedule("*/2 * * * * ?"))
                    .build();

            //定义一个JobDetail
            JobDetail job = newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                    .withIdentity("job1", "group1") //定义name/group
                    .usingJobData("name", "first-quartz") //定义属性
                    .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);

            //启动
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 增加定时任务
     *
     * @param name           任务名称
     * @param group          任务分组
     * @param clazz          执行的类
     * @param cronExpression 定时任务表达式
     * @throws SchedulerException 定时调用异常
     */
    private void addJob(String name, String group, Class<? extends Job> clazz, String cronExpression) throws SchedulerException {
        JobDetail job = newJob(clazz)
                .withIdentity(name, group)
                .build();
        Trigger trg = newTrigger()
                .withIdentity(name, group)
                .withSchedule(cronSchedule(cronExpression))
                .build();
        scheduler.scheduleJob(job, trg);
    }

    /**
     * 封装定时任务 - 立刻执行，且只执行一次
     *
     * @param name  任务名称
     * @param group 任务分组
     * @param clazz 执行的类
     * @throws SchedulerException 定时调用异常
     */
    private void addJobOnce(String name, String group, Class<? extends Job> clazz) throws SchedulerException {
        JobDetail jobDetail = newJob(clazz).withIdentity(name, group).build();
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().
                startNow().withIdentity(name, group).
                // repeatCount 重复次数。实际执行次数是 repeatCount+1。因为在startTime的时候一定会执行一次。
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}

