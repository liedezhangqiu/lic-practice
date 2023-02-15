package cn.lic.microservice.base.provider.test;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        //explain


    }
}
