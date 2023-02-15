package cn.lic.microservice.base.provider.test;



import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        HashMap hashMap = new HashMap();
        Vector vector = new Vector();
        vector.add(1);


        BlockingQueue blockingQueue = new ArrayBlockingQueue(6);

        Collections.unmodifiableList(null);
        Collections.sort(null);
        Thread.yield();



    }
}
