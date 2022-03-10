package jdbc.datasource.druid;

import jdbc.util.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-15:45
 * @Function Description ：
 * 使用新的工具类
 */
public class DruidDemo02 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = JDBCUtils2.getConnection();
            String sql = "insert into account values(null , ? , ? )";
            //获取pstmt对象
            pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1 , "王五" );
            pstmt.setDouble( 2 , 3000 );
            
            int count = pstmt.executeUpdate();
            System.out.println( count );
            
        }catch( SQLException e ){
            e.printStackTrace();
        }finally{
            JDBCUtils2.close( pstmt , conn );
        }
    }
}
