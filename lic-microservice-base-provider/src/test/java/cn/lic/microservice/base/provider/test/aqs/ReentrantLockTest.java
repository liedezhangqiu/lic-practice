package cn.lic.microservice.base.provider.test.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static MyReentrantLock reentrantLock = new MyReentrantLock(false);

    static ReentrantLock reentrantLock11 = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ReentrantLockTest");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
            new Thread(new MyRun()).start();
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " access");
                reentrantLock.lock();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
