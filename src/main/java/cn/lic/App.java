package cn.lic;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String a = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append("char");
        a.getBytes();
        HashSet hashSet=new HashSet();
        Vector vector= new Vector<>();
        Iterator iterator = null;

        ListIterator listIterator= new ListIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Object previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Object o) {

            }

            @Override
            public void add(Object o) {

            }
        };

    }
}
