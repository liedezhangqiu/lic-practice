package cn.lic.microservice.base.provider.test.manage;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestAnatation {

    public static void main(String[] args) {

    }

    public static final String getCName() {
        return "CNAME";
    }

    public static final String aname = "A_NAME";

    @RequestMapping(value = TestAnatation.aname)
    public void test() {

    }
}
