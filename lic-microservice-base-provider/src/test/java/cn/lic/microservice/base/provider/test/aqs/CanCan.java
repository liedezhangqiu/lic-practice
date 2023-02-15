package cn.lic.microservice.base.provider.test.aqs;

public class CanCan {

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("CANCAN ：" + finalI);
//                }
//            }).start();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("CAN : " + Thread.currentThread().getName() + "   - " + i);
                }
            }
        }).start();
        ReentrantLockTest.main(null);
    }
}
