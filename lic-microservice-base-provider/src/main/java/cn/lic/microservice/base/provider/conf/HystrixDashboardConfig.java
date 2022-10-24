package cn.lic.microservice.base.provider.conf;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixDashboardConfig {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Bean
    public ServletRegistrationBean getServlet() {
        logger.info("init HystrixMetricsStreamServlet");
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream"); // 这里一定是这个，不要在前面加什么 act 之类的了
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
