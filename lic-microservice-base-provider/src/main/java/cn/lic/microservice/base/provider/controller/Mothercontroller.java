package cn.lic.microservice.base.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mo")
public class Mothercontroller {

    @RequestMapping("ha")
    public String ha(){
        return "ddwdwa";
    }
}
