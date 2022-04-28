package principle.segregation;

/**
 * @author ： CodeWater
 * @create ：2022-04-28-20:00
 * @Function Description ：接口隔离原则
 * 没有使用
 * 1) 类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，如果接口 Interface1 对于类 A 和类 C
 * 来说不是最小接口，那么类 B 和类 D 必须去实现他们不需要的方法
 * 2) 将接口 Interface1 拆分为独立的几个接口，类 A 和类 C 分别与他们需要的接口建立依赖关系。也就是采用接口
 * 隔离原则
 * 3) 接口 Interface1 中出现的方法，根据实际情况拆分为三个接口
 */
public class Segregation {
    public static void main(String[] args) {
        
    }
}

//接口
interface Interface1 {
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class B implements Interface1 {
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
    public void operation4() {
        System.out.println("B 实现了 operation4");
    }
    public void operation5() {
        System.out.println("B 实现了 operation5");
    }
}

class D implements Interface1 {
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }
    public void operation2() {
        System.out.println("D 实现了 operation2");
    }
    public void operation3() {
        System.out.println("D 实现了 operation3");
    }
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

class A { //A 类通过接口 Interface1 依赖(使用) B 类，但是只会用到 1,2,3 方法
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend2(Interface1 i) {
        i.operation2();
    }
    public void depend3(Interface1 i) {
        i.operation3();
    }
}

class C { //C 类通过接口 Interface1 依赖(使用) D 类，但是只会用到 1,4,5 方法
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend4(Interface1 i) {
        i.operation4();
    }
    public void depend5(Interface1 i) {
        i.operation5();
    }
}