package cn.lic.microservice.base.provider.test.aqs;

import java.util.concurrent.locks.Condition;

public class ConditionStudy0202 {

    //还可以创建多个条件变量，如下所示，每一个条件变量都维护了一个条件队列：
    public static void main(String[] args) throws InterruptedException {
        // 创建锁对象
        MyReentrantLock lock = new MyReentrantLock();
        // 创建条件变量1
        Condition condition1 = lock.newCondition();
        // 条件变量2
        Condition condition2 = lock.newCondition();

        // 以下创建两个线程，里面都会获取锁和释放锁
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("await begin");//1
                condition1.await();
                System.out.println("await end");//5
                Thread.sleep(1000);
                System.out.println("condition2---signal---start");//6
                condition2.signal();
                System.out.println("condition2---signal---endend");//7
            } catch (InterruptedException e) {
                //
            } finally {
                lock.unlock();
            }

        });

        Thread thread2 = new Thread(() -> {

            lock.lock();
            try {
                System.out.println("signal begin");//2
                condition1.signal();
                System.out.println("signal end");//3
                Thread.sleep(1500);
                System.out.println("condition2---await---start");//4
                condition2.await();
                System.out.println("condition2---await---end");//8
            } catch (InterruptedException e) {
                //
            } finally {
                lock.unlock();
            }

        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();

    }
}
