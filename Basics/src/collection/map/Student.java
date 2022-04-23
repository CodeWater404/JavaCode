package collection.map;

import java.util.Objects;

/**
 * @author ： CodeWater
 * @create ：2022-02-23-13:56
 * @Function Description ：
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
//        使用Objects工具类需要导包java.util.Objects
        return age == student.age && Objects.equals(name, student.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
