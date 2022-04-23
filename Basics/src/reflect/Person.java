package reflect;

/**
 * @author ： CodeWater
 * @create ：2022-03-03-13:27
 * @Function Description ：
 */
public class Person {
    private String name;
    private int age;

    //    只能获取public修饰的成员变量
    public String a;
    protected String b;
    String c;//default省略
    private String d;

    public Person() {
    }

    public Person(String name, int age) {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eat....");
    }

    public void eat(String food) {
        System.out.println("eat..." + food);
    }
}
