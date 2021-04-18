package top.atpisher.my.shop1.web.admin.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.atpisher.my.shop1.commons.constant.ConstantUtils;
import top.atpisher.my.shop1.domain.TbUser;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @ClassName: LoginInterceptor
 * @Author: l1957
 * @Date: 2021/3/23 19:43
 * @Description: TODO
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user= (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        // 判断用户是否登录
        if(user==null){
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        //放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
