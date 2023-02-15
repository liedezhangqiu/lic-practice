package cn.lic.microservice.base.provider.test;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.lang.management.ManagementFactory;
import java.security.AccessControlContext;
import java.util.concurrent.*;

public class CLassTest {

    public static void main(String[] args) {
        System.out.println(System.lineSeparator());
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(JSON.toJSONString(securityManager));

        try {
            Class t = Class.forName("cn.lic.microservice.base.provider.test.Test");
            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("in callable " + printThread());
                    return null;
                }
            };


            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("in runnable " + printThread());
                }
            };
            new Thread(runnable).start();

            FutureTask futureTask = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("call() call() call() " + printThread());
                    return new String("string words");
                }
            });
            new Thread(futureTask).start();
            System.out.println(futureTask.get());

            BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,6000,
                    TimeUnit.MICROSECONDS,workQueue);
            executor.submit(runnable);
            executor.submit(callable);

            // CycliBarriar and CountdownLatch

            // CycliBarriar cycliBarriar = CycliBarriar




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static String printThread(){
        return Thread.currentThread().getName();
    }
}
