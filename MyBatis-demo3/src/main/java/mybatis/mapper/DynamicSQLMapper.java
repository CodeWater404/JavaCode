package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-16-23:37
 * @Function Description ：
 */
public interface DynamicSQLMapper {
    //    多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    //    测试choose、when、otherwise
    List<Emp> getEmpByChoose(Emp emp);

    //    通过数组实现批量删除 , param指定传到xml里面的参数名
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    //    批量删除
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
