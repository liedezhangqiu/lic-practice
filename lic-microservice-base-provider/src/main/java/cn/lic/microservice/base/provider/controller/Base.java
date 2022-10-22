package cn.lic.microservice.base.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bs")
public class Base {

    @RequestMapping("/ha")
    public String hah(){
        System.out.println(".....");
        return "ojjjkkk";
    }

    @RequestMapping("hb")
    public String hb(){
        System.out.println(".....");
        return "ojjjhbhbhbkkk";
    }
}
