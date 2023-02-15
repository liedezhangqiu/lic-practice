package cn.lic.microservice.base.provider.test;

import java.util.HashMap;

public class TestHashMap {

    public static void main(String[] args) {


        HashMap hashMap = new HashMap();
        hashMap.put(new Object(), new Object());
        hashMap.get(new Object());
        System.out.println();

        int h;
        Object key = new Object();
        int hash = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(hash);

        System.out.println(25 & hash);
    }


    public static void toStringsStr() {

    }
}

