package demo2.factoryBean;

import demo2.collectionType.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-23:16
 * @Function Description ：
 */
public class MyBean implements FactoryBean<Course> {
    /*factory的bean类型在这里确定*/
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
