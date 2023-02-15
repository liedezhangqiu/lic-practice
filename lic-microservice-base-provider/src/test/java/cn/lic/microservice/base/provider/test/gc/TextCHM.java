package cn.lic.microservice.base.provider.test.gc;

import org.bouncycastle.tsp.TSPUtil;

import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class TextCHM {

    static final int HASH_BITS = 0x7fffffff;

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }


    public static void main(String[] args) {

        System.out.println(HASH_BITS);
        int hcode = new String("dwadwa").hashCode();
        System.out.println(hcode);
        System.out.println(hcode >>> 16);
        int cd = hcode ^ (hcode >>> 16);
        System.out.println(cd);
        System.out.println(cd & HASH_BITS);
        System.out.println( HASH_BITS +cd);
        System.out.println( 0^0);


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}

class MyClassLoad extends ClassLoader{


}
