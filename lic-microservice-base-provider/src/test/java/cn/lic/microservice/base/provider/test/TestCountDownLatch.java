package cn.lic.microservice.base.provider.test;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("access in thread1 ");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread1 over");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 8; i++) {
                        System.out.println("access in thread2 " + countDownLatch.getCount());
                        Thread.sleep(1000);
                        countDownLatch.countDown();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
