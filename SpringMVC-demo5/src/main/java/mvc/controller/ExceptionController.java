package mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ： CodeWater
 * @create ：2022-04-13-21:02
 * @Function Description ：
 */
@ControllerAdvice
public class ExceptionController {
    //    设置可能出现的异常
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model) {
//        把错误信息共享
        model.addAttribute("ex", ex);
        return "error";
    }
}
