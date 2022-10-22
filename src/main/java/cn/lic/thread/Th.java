package cn.lic.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Th {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("run in thread...");
            }
        });
        thread.start();
        //thread.join(3000);
        Thread.sleep(3000);
        thread.suspend();
        System.out.println("main thread over...");
        //thread.join();
        thread.getState();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
}
