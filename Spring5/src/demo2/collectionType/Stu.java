package demo2.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-22:13
 * @Function Description ：
 * 演示集合类型的依赖注入
 */
public class Stu {
    private String[] courses;
    private List<String> list;
    private Map<String, String> maps;
    private Set<String> sets;

    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test() {
//        用工具类打印输出元素，就不用for遍历了
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(sets);
        System.out.println(maps);
        System.out.println(courseList);
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }
}
