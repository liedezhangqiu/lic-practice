package cn.lic.microservice.base.provider.listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class TestListener implements SpringApplicationRunListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public TestListener(SpringApplication application, String[] args) {
        logger.info("application : " + application.getClass().getName().toString());
        logger.info("args : " + JSON.toJSONString(args));
    }

    @Override
    public void starting() {
        logger.info("starting ......");
        SpringApplicationRunListener.super.starting();
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("environmentPrepared ......");
        SpringApplicationRunListener.super.environmentPrepared(environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("contextPrepared ......");
        SpringApplicationRunListener.super.contextPrepared(context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logger.info("contextLoaded ......");
        SpringApplicationRunListener.super.contextLoaded(context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        logger.info("started ......");
        SpringApplicationRunListener.super.started(context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        logger.info("running ......");
        SpringApplicationRunListener.super.running(context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        logger.info("failed ......");
        SpringApplicationRunListener.super.failed(context, exception);
    }
}
