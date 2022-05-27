package principle.ocp;

/**
 * @author ： CodeWater
 * @create ：2022-05-03-16:37
 * @Function Description ：修改:
 * 把创建 Shape 类做成抽象类，并提供一个抽象的 draw 方法，让子类去实现即可，这样我们有新的图形
 * 种类时，只需要让新的图形类继承 Shape，并实现 draw 方法即可，使用方的代码就不需要修 ->
 */
public class Ocp2 {
    public static void main(String[] args) {
//使用看看存在的问题
        GraphicEditor2 graphicEditor = new GraphicEditor2();
        graphicEditor.drawShape(new Rectangle2());
        graphicEditor.drawShape(new Circle2());
        graphicEditor.drawShape(new Triangle2());
        graphicEditor.drawShape(new OtherGraphic2());

    }
}

//这是一个用于绘图的类 [使用方]
class GraphicEditor2 {
    //接收 Shape 对象，调用 draw 方法
    public void drawShape(Shape2 s) {
        s.draw();
    }
}

//Shape 类，基类
abstract class Shape2 {
    int m_type;

    abstract void draw();//抽象方法
}

class Rectangle2 extends Shape2 {
    Rectangle2() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
// TODO Auto-generated method stub
        System.out.println(" 绘制矩形 ");
    }
}

class Circle2 extends Shape2 {
    Circle2() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
// TODO Auto-generated method stub
        System.out.println(" 绘制圆形 ");
    }
}

//新增画三角形
class Triangle2 extends Shape2 {
    Triangle2() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
// TODO Auto-generated method stub
        System.out.println(" 绘制三角形 ");
    }
}

//新增一个图形
class OtherGraphic2 extends Shape2 {
    OtherGraphic2() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
// TODO Auto-generated method stub
        System.out.println(" 绘制其它图形 ");
    }
}
