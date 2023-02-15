package cn.lic.microservice.base.provider.test.lock;

import cn.lic.microservice.base.provider.test.SemaphoreTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class TestSignal {

    public static int sempCount = 10;

    public static Semaphore semaphore = new Semaphore(sempCount, false);

    public static ThreadPoolTaskExecutor threadPoolExecutor;

    static{
        threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.initialize();
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaxPoolSize(10);
        threadPoolExecutor.setQueueCapacity(10);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                rejectedExecution(r, executor);
            }
        });
    }


    public static void execute(int index) {

        try {
            semaphore.acquire();
            System.out.println("sem index {" + index % sempCount + "} was in use! ");
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            System.out.println("第 " + (i / sempCount + 1) + " 组开始执行。");
            int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    execute(finalI);
                }
            });
        }

    }
}
