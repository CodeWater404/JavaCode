package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author ： CodeWater
 * @create ：2022-04-17-14:46
 * @Function Description ：
 */
public interface CacheMapper {
//    测试一级缓存
    Emp getEmpById(@Param("eid") Integer eid);
//    测试增删改会清空缓存
    void insertEmp(Emp emp );
}
