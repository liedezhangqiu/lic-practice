package cn.lic.microservice.base.provider.test;

import cn.lic.microservice.base.provider.model.Book;

public class TestBinglie {

    public static void main(String[] args) {
        if (false && b()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean a() {
        System.out.println("a()");
        return false;
    }

    public static boolean b() {
        System.out.println("b()");
        return true;
    }
}
