package top.atpisher.my.shop1.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.atpisher.my.shop1.commons.constant.ConstantUtils;
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.service.TbUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LoginController
 * @Author: l1957
 * @Date: 2021/4/3 15:21
 * @Description: TODO
 */
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;
    /*
    跳转登录
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    /*
    登录逻辑
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String passwd, HttpServletRequest httpServletRequest, Model model){
        TbUser tbUser=tbUserService.login(email,passwd);
        if(tbUser==null){
            model.addAttribute("message","用户名或者密码错误,请重新输入");
            return login();
        }else{
            //将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            return "redirect:/main";
        }


    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest httpServletRequest){
        //彻底清除session信息
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
