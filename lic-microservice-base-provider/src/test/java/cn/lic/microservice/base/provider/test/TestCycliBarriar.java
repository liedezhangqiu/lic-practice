package cn.lic.microservice.base.provider.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCycliBarriar {

    protected static CyclicBarrier cycliBarriar = new CyclicBarrier(2);

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("access in thread1 ");
                try {
                    Thread.sleep(600);
                    cycliBarriar.await();
                    System.out.println("thread1 over");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("access in thread2 ");
                try {
                    System.out.println(" " + 1);
                    Thread.sleep(1000);
                    cycliBarriar.await();
                    System.out.println("thread2 over ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
