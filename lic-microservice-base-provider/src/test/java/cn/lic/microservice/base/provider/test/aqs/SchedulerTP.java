package cn.lic.microservice.base.provider.test.aqs;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerTP {

    public static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
            new ScheduledThreadPoolExecutor(2, new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    executor.submit(r);
                }
            });

    public static void main(String[] args) {

        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("r" +
                        "rrrrrrr rr rr rr ");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
