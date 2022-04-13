package mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ： CodeWater
 * @create ：2022-04-13-17:01
 * @Function Description ：
 */
@Component//可以写为普通组件交给ioc管理
public class FirstInterceptor implements HandlerInterceptor {
    
    /*控制器前执行，实行拦截功能return false是拦截*/
    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object handler ) throws Exception {
        System.out.println( "FirstInterceptor----->preHandler" );
        return true;
    }
    
    /*控制器执行后执行*/
    @Override
    public void postHandle(HttpServletRequest request , HttpServletResponse response , Object handler , ModelAndView modelAndView ) throws Exception {
        System.out.println( "FirstInterceptor------>postHandler" );
    }
    
    /*模型和视图渲染完毕后执行*/
    @Override
    public void afterCompletion( HttpServletRequest request , HttpServletResponse response , Object  handler , Exception ex ) throws Exception {
        System.out.println( "FirstInterceptor---->afterCompletion" );
    }
    
    
}
