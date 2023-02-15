package cn.lic.microservice.base.provider.test.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    interface IHello {
        void sayHello();
        void sayHello2();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }

        @Override
        public void sayHello2() {
            System.out.println("hello world2");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        private void aopBefore() {
            System.out.println("aopBefore");
        }

        private void aopAfter() {
            System.out.println("aopAfter");
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            if ("sayHello".equals(method.getName())) {
                aopBefore();
            }
            Object object = method.invoke(originalObj, args);
            if ("sayHello".equals(method.getName())) {
                aopAfter();
            }
            return object;
        }

    }

    public static void main(String[] args) throws Throwable {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();

        DynamicProxy dynamicProxy = new DynamicProxy();
        IHello object = (IHello) dynamicProxy.bind(new Hello());
        System.out.println("------");
        dynamicProxy.invoke(object, IHello.class.getMethod("sayHello"), null);

        dynamicProxy.invoke(object, IHello.class.getMethod("sayHello2"), null);
    }

}