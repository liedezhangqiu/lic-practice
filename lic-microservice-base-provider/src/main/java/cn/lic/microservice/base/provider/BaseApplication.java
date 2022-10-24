package cn.lic.microservice.base.provider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


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

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);

    }

}
