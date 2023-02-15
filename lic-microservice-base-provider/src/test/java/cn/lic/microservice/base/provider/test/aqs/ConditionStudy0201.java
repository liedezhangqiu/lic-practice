package cn.lic.microservice.base.provider.test.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class ConditionStudy0201 {

    /**
     * 什么是条件变量呢？我们在开始介绍AQS的时候，还有一个内部类没有说，就是ConditionObject，还记得前面说过
     * 的Unsafe中的park和unpark方法吗？而这个ConditionObject就对这两个方法进行了一次封装，await()和signal()方法，
     * 但是更灵活，可以创建多个条件变量，每个条件变量维护一个条件队列（就是一个单向链表，可以看到Node这个内部类中个属性
     * 是nextWaiter）；
     * 注意：每一个条件变量里面都维护了一个条件队列
     *
     * 举个例子，如下所示；
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建锁对象
        MyReentrantLock lock = new MyReentrantLock();
        // 创建条件变量
        Condition condition = lock.newCondition();
        // 以下创建两个线程，里面都会获取锁和释放锁
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("await begin");
                // 注意，这里调用条件变量的await方法，当前线程就会丢到condition条件变量中
                // 的条件队列中阻塞
                condition.await(800, TimeUnit.MILLISECONDS);
                System.out.println("await end");
            } catch (InterruptedException e) {
                //
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("signal begin");
                // 唤醒被condition变量内部队列中的某个线程
                condition.signal();
                System.out.println("signal end");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        Thread.sleep(5000);
        thread2.start();
    }
}

