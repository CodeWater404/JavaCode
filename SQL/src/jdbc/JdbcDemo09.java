package jdbc;

import jdbc.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-03-09-10:49
 * @Function Description ：
 * 练习：
 * * 需求：
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 * * select * from user where username = "" and password = "";
 * * 如果这个sql有查询结果，则成功，反之，则失败
 */
public class JdbcDemo09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        boolean flag = new JdbcDemo09().login2(username, password);
        if (flag) {
            System.out.println("登录成功");

        } else {
            System.out.println("用户名或密码错误！！！");

        }
    }

    /*登录方法
     * */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return false;
    }

    /*登录方法，使用PreparedStatement:可以防止sql注入
     * */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            //这里的字符串也不一样
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
