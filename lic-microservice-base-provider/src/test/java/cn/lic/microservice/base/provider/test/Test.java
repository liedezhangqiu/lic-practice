package cn.lic.microservice.base.provider.test;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test {

    public void say(){
        System.out.println("say() say() say() say() say()");
    }
    private static Object object;

    public static void main(String[] args) {


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Object key = new Object();
        Object val = new Object();
        concurrentHashMap.put(key, val);
        Object v2 = concurrentHashMap.get(key);
        System.out.println(val == v2);
        System.out.println(val.equals(v2));
        //  curator

        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(new TreeT());
        treeSet.add(new TreeT());
        JSON.toJSONString(treeSet);


        TreeMap treeMap = new TreeMap();
//        treeMap.put(new Object(),new Object());


        TreeT[] treeTS = (TreeT[]) Array.newInstance(TreeT.class, 8);
        System.out.println(treeTS);


        HashMap hashMap = new HashMap();
        hashMap.put(new Object(), new Object());
        System.out.println(hashMap);

        String a = "";

        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        integers.add(222);
        object = new Object();

        Error error = new Error();
        Exception exception = new Exception();







    }

    static class TreeT implements java.lang.Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
