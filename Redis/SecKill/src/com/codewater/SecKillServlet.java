package com.codewater;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author ： CodeWater
 * @create ：2022-05-28-22:02
 * @Function Description ：秒杀案例
 */
public class SecKillServlet extends HttpServlet {
    private static final Long serialVersionUID = 1L;
    
    public SecKillServlet(){
        super();
    }
    
    protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String userid = new Random().nextInt(50000) + "" ;
        String prodid = request.getParameter( "prodid" );
        
        boolean isSuccess = SecKill_redisByScript.doSecKill( userid , prodid );
        response.getWriter().print( isSuccess );
        
    }
    
}
