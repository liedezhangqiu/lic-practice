package cn.lic.microservice.base.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHookDefault;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/bs")
public class BaseController {

    @RequestMapping("/ha")
    public String hah() {
        System.out.println(".....");

        return "ojjjkkk";
    }

    private static final String hName = "execution.isolation.thread.timeoutInMilliseconds";

    @HystrixCommand(fallbackMethod = "fb", commandProperties = {@HystrixProperty(name = hName, value = "3000")})
    @RequestMapping("hb")
    public String hb() throws InterruptedException {
        System.out.println(".....");
        if (new Random().nextInt(2) == 1) {
            return "ojjjhbhbhbkkk";
        } else {
            Thread.sleep(3200);
            return "error in method hb()";
        }
    }

    private String fb() {
        return "error in method fb()";
    }

    /**
     * 启用断路器      @HystrixProperty(name = "circuitBreaker.enabled", value = "true")
     * 设置请求次数    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")
     * 设置时间窗口期  @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
     * 设置失败率     @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "getNameFallBack", commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),})

    public static String getName() {
        return hName;
    }

    public String getNameFallBack() {
        return super.toString();
    }
}
