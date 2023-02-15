package cn.lic.microservice.base.provider.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CanFinalCouldBeModify {

    private static  Unsafe unsafe;

    private static final long stateOffset;


    static {
        initUnsafe();
    }
    private static void initUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe1 =  (Unsafe) f.get(null);
            unsafe = unsafe1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    static {
        stateOffset = 10L;
    }

    public static void main(String[] args) {
        System.out.println(stateOffset);
        unsafe.compareAndSwapLong(CanFinalCouldBeModify.class, stateOffset, stateOffset, 1000);
        System.out.println(stateOffset);
    }
}
