package cn.lic.microservice.base.facade;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "lic-microservice-base-service", path = "/base")
public interface BaseFacade {

    @RequestMapping("/bs/ha")
    String doBase();
}
