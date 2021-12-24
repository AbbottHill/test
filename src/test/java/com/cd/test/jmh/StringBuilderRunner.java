package com.cd.test.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author buhao
 * @version StringBuilderRunner.java, v 0.1 2018-12-25 09:53 buhao
 */
public class StringBuilderRunner {

    public static void main( String[] args ) throws RunnerException {
        Options opt = new OptionsBuilder()
                // 导入要测试的类
                .include(StringConnectBenchmark.class.getSimpleName())
                // 预热5轮
                .warmupIterations(2)
                // 度量10轮
                .measurementIterations(2)
                .mode(Mode.Throughput)
//                .mode(Mode.AverageTime)
                //默认JMH为每个试验(迭代集合)fork一个新的java进程。
                // 这样可以防止前面收集的“资料”——其他被加载类以及它们执行的信息对当前测试的影响。
                // 比如，实现了相同接口的两个类，测试它们的性能，
                // 那么第一个实现(目标测试类)可能比第二个快，
                // 因为JIT发现第二个实现类后就把第一个实现的直接方法调用替换为接口方法调用。
                // 因此，不要把forks设为0除非你清楚这样做的目的
                .forks(1)
                .build();

        new Runner(opt).run();


    }

}