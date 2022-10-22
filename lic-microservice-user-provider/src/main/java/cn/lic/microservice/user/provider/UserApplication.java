package cn.lic.microservice.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.lic.microservice.user.provider.controller", "cn.lic.microservice.base.facade"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
