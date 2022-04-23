package demo2.collectionType;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-22:15
 * @Function Description ：
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }

}

