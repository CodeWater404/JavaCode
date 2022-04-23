package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-16-17:42
 * @Function Description ：
 */
public interface EmpMapper {
    /*查询所有员工
     * */
    List<Emp> getAllEmp();

    //    查询员工及部门
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
