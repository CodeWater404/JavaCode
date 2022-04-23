package demo1.bean;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-21:45
 * @Function Description ：
 * 部门类
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
