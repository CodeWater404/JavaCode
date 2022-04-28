package principle.segregation;

/**
 * @author ： CodeWater
 * @create ：2022-04-28-20:11
 * @Function Description ：使用接口隔离
 * 
 */
public class Segregation2 {
    public static void main(String[] args) {
        // 使用一把
        AA a = new AA();
        a.depend1(new BB()); // A 类通过接口去依赖 B 类
        a.depend2(new BB());
        a.depend3(new BB());
        
        CC c = new CC();
        c.depend1(new DD()); // C 类通过接口去依赖(使用)D 类
        c.depend4(new DD());
        c.depend5(new DD());
    }
}


// 接口 1
interface Interface11 {
    void operation1();
}
// 接口 2
interface Interface2 {
    void operation2();
    void operation3();
}
// 接口 3
interface Interface3 {
    void operation4();
    void operation5();
}

class BB implements Interface11 , Interface2{ 
        public void operation1() {
    System.out.println("B 实现了 operation1");
}
        public void operation2() {
            System.out.println("B 实现了 operation2");
        }
        public void operation3() {
            System.out.println("B 实现了 operation3");
        }
}

class DD implements Interface11, Interface3 {
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

class AA { // A 类通过接口 Interface1,Interface2 依赖(使用) B 类，但是只会用到 1,2,3 方法
    public void depend1(Interface11 i) {
        i.operation1();
    }
    public void depend2(Interface2 i) {
        i.operation2();
    }
    public void depend3(Interface2 i) {
        i.operation3();
    }
}
class CC { // C 类通过接口 Interface1,Interface3 依赖(使用) D 类，但是只会用到 1,4,5 方法
    public void depend1(Interface11 i) {
        i.operation1();
    }
    public void depend4(Interface3 i) {
        i.operation4();
    }
    public void depend5(Interface3 i) {
        i.operation5();
    }
}