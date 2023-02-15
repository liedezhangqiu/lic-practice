package cn.lic.microservice.base.provider.test.gc;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class TestVM {
    public static void main(String[] args) {
        System.out.println("main");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("over");
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        System.getenv().forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " : " + s2);
                String put = concurrentHashMap.put(s, s2);
            }
        });
        System.out.println(JSON.toJSONString(concurrentHashMap));
    }
}
