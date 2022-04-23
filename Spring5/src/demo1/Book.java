package demo1;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-19:56
 * @Function Description ：
 * 演示set注入
 */
public class Book {
    private String bname;
    private String bauthor;
    private String address;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo() {
        System.out.println(bname + " :" + bauthor + ":" + address);
    }
}
