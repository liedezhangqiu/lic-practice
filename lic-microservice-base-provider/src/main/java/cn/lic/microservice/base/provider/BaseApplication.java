package cn.lic.microservice.base.provider;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import py4j.GatewayServer;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @EnableCaching注释触发了一个后处理器，该后处理器检查每个Spring bean是否存在公共方法上的缓存注释。如果找到这样的注释，
 * 将自动创建一个代理来拦截方法调用并相应地处理缓存行为。
 * <p>
 * 后处理器处理@Cacheable、@CachePut和@CacheEvict注释。您可以参考Javadoc和参考指南了解更多详细信息。
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
//@EnableFeignClients(basePackages = {"cn.lic.microservice.base.provider.controller", "cn.lic.microservice.base.facade"})
//@EnableGlobalMethodSecurity(prePostEnabled = true)   //spring-security
//@EnableCircuitBreaker  //断路器
@EnableHystrixDashboard
@EnableHystrix
public class BaseApplication {

    private static Logger logger = LoggerFactory.getLogger(BaseApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BaseApplication.class);
        applicationContext.registerShutdownHook();

        // py4j服务
        GatewayServer gatewayServer = new GatewayServer();
        gatewayServer.start();
        System.out.println("py4j gateway server was started ...");

    }

    /**
     * 获取系统信息
     *
     * @return
     */
    public static String getSystemProperties() {
        logger.info("void invoke -> ps()");
        Properties props = System.getProperties();
        return JSON.toJSONString(props);
    }

    /**
     * 内存回收相关  indicator
     *
     * @return
     */
    public static String getG() {
        // return JSON.toJSONString(ManagementFactory.getClassLoadingMXBean());
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        return JSON.toJSONString(garbageCollectorMXBeans);
    }

    /**
     * @return
     */
    public static String getM() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getMemoryManagerMXBeans());

        return JSON.toJSONString(objects);
    }

    /**
     * @return
     */
    public static String getC() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getClassLoadingMXBean());

        return JSON.toJSONString(objects);
    }

    /**
     * @return
     */
    public static String getCM() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getCompilationMXBean());

        return JSON.toJSONString(objects);
    }

    /**
     * @return
     */
    public static String getM2() { // 这个方法 python 端会报错，后面调试
        List<Object> objects = Collections.singletonList(ManagementFactory.getMemoryPoolMXBeans());
        return JSON.toJSONString(objects);
    }

    /**
     * @return
     */
    public static String getM3() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getOperatingSystemMXBean());
        return JSON.toJSONString(objects);
    }

    public static String getM4() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getThreadMXBean());
        return JSON.toJSONString(objects);
    }

    public static String getM5() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getRuntimeMXBean());
        return JSON.toJSONString(objects);


    }


    /**
     * 获取线程的堆栈信息
     *
     * @return
     */
    public static String getM6() {
        List<Object> objects = Collections.singletonList(ManagementFactory.getThreadMXBean());
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        return JSON.toJSONString(objects);


    }

}
