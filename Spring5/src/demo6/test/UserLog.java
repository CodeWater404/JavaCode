package demo6.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-23:55
 * @Function Description ：
 * spring5新功能:log4j2(需要放在src下才生效；如果是maven工程的话，需要放在resource下）
 */
public class UserLog {
    private static final Logger log = LoggerFactory.getLogger( UserLog.class ) ;
    
    public static void main( String[] args ){
        log.info( "hello log4j2" );
        log.warn( "hell log4j 2" );
    }
}
