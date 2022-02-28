package io;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-12:41
 * @Function Description ：
 */
public class Student implements java.io.Serializable {
    private String name;
    private String pwd;

    public Student(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Student() {
    }
}
