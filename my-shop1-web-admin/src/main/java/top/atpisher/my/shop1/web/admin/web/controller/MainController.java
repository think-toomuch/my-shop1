package top.atpisher.my.shop1.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: MainController
 * @Author: l1957
 * @Date: 2021/4/3 15:21
 * @Description: TODO
 */
@Controller
public class MainController {
    /*
      跳转到首页
       */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
