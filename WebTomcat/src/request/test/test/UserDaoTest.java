package request.test.test;

//从src开始导

import org.junit.Test;
import request.test.dao.UserDao;
import request.test.domain.User;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:13
 * @Function Description ：
 */
public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        //正确查询
//        loginuser.setPassword( "123" );
//        错误查询返回null;还是会有错误信息，但是这次会打印null
        loginuser.setPassword("123111");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
