package cn.lic.microservice.base.provider.model;

public class Teacher {

    private String name;
    private String age;
    private String subject;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = "am";//Integer.valueOf(42);

    }

}
