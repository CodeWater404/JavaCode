package mybatis.test;

import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-16-17:43
 * @Function Description ：
 * /**
 * 解决字段名和属性名不一致的情况：
 * a>为字段起别名，保持和属性名的一致
 * b>设置全局配置，将_自动映射为驼峰
 * <setting name="mapUnderscoreToCamelCase" value="true"/>
 * c>通过resultMap设置自定义的映射关系
 * <resultMap id="empResultMap" type="Emp">
 * <id property="eid" column="eid"></id>
 * <result property="empName" column="emp_name"></result>
 * <result property="age" column="age"></result>
 * <result property="sex" column="sex"></result>
 * <result property="email" column="email"></result>
 * </resultMap>
 * <p>
 * 处理多对一的映射关系：
 * a>级联属性赋值
 * b>association
 * c>分步查询
 * <p>
 * 处理一对多的映射关系
 * a>collection
 * b>分步查询
 */
public class ResultMapperTest {

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    //    查询员工及部门
    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(2);
        System.out.println(emp);
    }

    //    查询员工信息及其部门，通过分步查询
    @Test
    public void testGetEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
//        分步查询出个人、部门
//        System.out.println( emp );
//        开启延迟加载，只差个人名字,部门就不会查了；如果不开的话，会先全部查出，在输出
        System.out.println(emp.getEmpName());
        System.out.println("---------------------------------");
        System.out.println(emp.getDept());
    }

    //    查询部门及其员工
    @Test
    public void testDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    //    查询部门及其员工，分步查询
    @Test
    public void testDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(2);
//        输出所有信息
//        System.out.println( dept );
//        只输出部门，不会查员工，延迟
        System.out.println(dept.getDeptName());
    }
}
