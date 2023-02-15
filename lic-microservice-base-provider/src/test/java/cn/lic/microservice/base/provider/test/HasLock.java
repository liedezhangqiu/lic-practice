package cn.lic.microservice.base.provider.test;

public class HasLock {

    public static void main(String[] args) {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread ...");
                for (;;){
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("....");
                }

            }
        });
        thread.start();
    }
}
