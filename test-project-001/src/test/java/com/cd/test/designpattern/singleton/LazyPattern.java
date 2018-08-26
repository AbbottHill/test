package com.cd.test.designpattern.singleton;

// 双重检查
public class LazyPattern {
    /**
     * 使用volatile关键字的目的不是保证可见性（synchronized已经保证了可见性），而是为了保证顺序性。具体来说，
     * INSTANCE = new Singleton()不是原子操作，实际上被拆分为了三步：1) 分配内存；2) 初始化对象；3) 将INSTANCE指向分配的对象内存地址。
     * 如果没有volatile，可能会发生指令重排，使得INSTANCE先指向内存地址，而对象尚未初始化，其它线程直接使用INSTANCE引用进行对象操作时出错。
     */
    private static volatile LazyPattern INSTANCE;

    private LazyPattern() {
    }

    ;

    public static LazyPattern getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyPattern();
                }
            }
        }
        return INSTANCE;
    }
}

class LazyPattern1 {
    private LazyPattern1() {
    }
//
//    /**
//     * 类级内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
//     * 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
//     */
//    private static class SingletonHolder {
//        /**
//         * 静态初始化器，由JVM来保证线程安全
//         */
//        private static LazyPattern1 instance = new LazyPattern1();
//    }
//
//    public static LazyPattern1 getInstance() {
//        return SingletonHolder.instance;
//    }


    // JVM 初始化类线程安全
    private static class InnerClass {
        private static LazyPattern1 instance = new LazyPattern1();
    }

    public static LazyPattern1 getInstance() {
        return InnerClass.instance;
    }

}
