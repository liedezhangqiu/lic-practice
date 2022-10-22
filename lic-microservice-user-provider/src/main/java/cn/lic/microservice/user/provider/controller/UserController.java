package cn.lic.microservice.user.provider.controller;


import cn.lic.microservice.base.facade.BaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/us")
public class UserController {

    @Autowired
    BaseFacade baseFacade;

    @RequestMapping("/g")
    public String gs() {
        return "aaaaaaa";
    }


    @RequestMapping("/g2")
    public String gs2() {
        String s = baseFacade.doBase();
        System.out.println(s);
        return s;
    }
}
