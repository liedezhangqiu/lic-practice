package cn.lic.microservice.base.provider.test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

public class WaitSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 ");
                try {
                    Thread.sleep(2000);
                    System.out.println("thread1 over");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        thread1.start();

        Thread thread3 =new Thread();

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("thread2 ");
                try {
                    new Object().wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread2 over");
            }
        });






    }
}
