package cn.lic.microservice.base.provider.test.gc;

public class TestGC {

    /**
     * 启动参数
     * -verbose:gc -XX:+PrintGCDetails -XX:+PrintGC -XX:+PrintFlagsFinal
     *
     * 执行(在test/java 目录):
     * java -verbose:gc -XX:+PrintGCDetails -XX:+PrintGC -XX:+PrintFlagsFinal cn.lic.microservice.base.provider.test.gc.TestGC
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main");

        byte[] bytes = new byte[1024*1024*50];
        Thread.sleep(2000);
        System.out.println("gc。。。");
        System.gc();

        Thread.sleep(1000);
    }
}
