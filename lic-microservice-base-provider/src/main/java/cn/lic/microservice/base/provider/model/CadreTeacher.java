package cn.lic.microservice.base.provider.model;

import java.util.ArrayList;
import java.util.List;

public interface CadreTeacher<C extends List> {

    void beatStudent(C c);

    public static void main(String[] args) {
        System.out.println(89 >> 3);
        System.out.println(11 << 3);
    }

}

class A implements CadreTeacher<ArrayList> {

    @Override
    public void beatStudent(ArrayList arrayList) {
        for (Object o : arrayList) {
            System.out.println(o.toString());
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.beatStudent(new ArrayList() {
            {
                add(1);
                add(2);
                add("3edawd");
            }
        });
    }

}
