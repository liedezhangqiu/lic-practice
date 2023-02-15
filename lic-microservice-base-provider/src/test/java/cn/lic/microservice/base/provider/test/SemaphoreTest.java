package cn.lic.microservice.base.provider.test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static Semaphore mSemaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }
    }

    private static void test() {
        try {
            // 从 mSemaphore 获取信息 + 1，mSemaphore 本身信号 -1 ，如果 mSemaphore 本身信息为0 则线程阻塞
            mSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 进来了");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 出去了");
        // 释放信号量，
        mSemaphore.release();
    }

}
