package jdbc.jdbctemplate;

import jdbc.domain.Emp;
import jdbc.util.JDBCUtils2;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-15:47
 * @Function Description ：
 * 
 */
public class JdbcTemplateDemo02 {
//    junit单元测试，让方法可以独立运行
    
    private JdbcTemplate template = new JdbcTemplate( JDBCUtils2.getDataSource() );
    
//    修改数据
    @Test
    public void test1(){
        String sql = "update emp set salary = 1000 where id = 1001";
        int count = template.update( sql );
        System.out.println( count );
    }
    
//    添加一条记录
    @Test
    public void test2(){
        String sql = "insert into user(  username , password ) values (  ? , ? )";
        int count = template.update( sql , "郭靖" , 10 );
        System.out.println( count );
    }
    
//    删除刚刚添加的记录
    @Test
    public void test3(){
        String sql = "delete from user where id = ?";
        int count = template.update( sql , 3 );
        System.out.println( count );
    }
    
    //查询id为1001的记录，并将其封装为Map的集合;查询的结果长度只能是1
    @Test
    public void test4(){
        String sql = "select * from emp where id = ? ";
//        String键值是[id, ename, job_id, mgr, joindate, salary, bonus, dept_id]
        Map<String , Object> map = template.queryForMap( sql , 1001 );
        System.out.println( map );
    }
    
    
    //查询所有记录，封装为list
    @Test
    public void test5(){
        String sql = "select * from emp";
        List< Map<String , Object> > list = template.queryForList( sql );
        
        for( Map<String , Object> stringObjectMap : list ){
//            System.out.print( stringObjectMap.keySet() );
            System.out.println( stringObjectMap );
        }
        
    }
    
//    查询所有记录。将其封装为emp对象的list集合
    @Test
    public void test36(){
        String sql = "select * from emp";
        List<Emp> list = template.query( sql , new RowMapper<Emp>(){
            @Override
            public Emp mapRow( ResultSet rs , int i ) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt( "job_id" );
                int mgr = rs.getInt( "mgr" );
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt( "dept_id" );
                emp.setId( id );
                emp.setEname( ename );
                emp.setJob_id( job_id );
                emp.setMgr( mgr );
                emp.setJoindate( joindate );
                emp.setSalary( salary );
                emp.setBonus( bonus );
                emp.setDept_id( dept_id );
                
                return emp;
            }
        } );
        
        for( Emp emp : list){
            System.out.println( emp );
        }
    }
    
    
    //查询总记录数
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject( sql, Long.class );
        System.out.println(total);
    }
}
