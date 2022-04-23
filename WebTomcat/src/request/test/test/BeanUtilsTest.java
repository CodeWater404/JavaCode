package request.test.test;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import request.test.domain.User;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:13
 * @Function Description ：
 * 测试bean的property方法
 * 属性和成员变量不一样：userr中gender是变量，sethehe方法截取后的hehe是属性
 */

public class BeanUtilsTest {
    @Test
    public void test() {
        User user = new User();
        try {
            //设置user的属性
            BeanUtils.setProperty(user, "hehe", "male");
            System.out.println(user);

//            拿到指定属性
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
