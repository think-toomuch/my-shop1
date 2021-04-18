package top.atpisher.my.shop1.web.admin.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.atpisher.my.shop1.commons.constant.ConstantUtils;
import top.atpisher.my.shop1.domain.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: PermissionInterceptor
 * 权限拦截器
 * @Author: l1957
 * @Date: 2021/3/23 22:43
 * @Description: TODO
 */
public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果请求来自登录页
        if (modelAndView!=null&&modelAndView.getViewName()!=null&&modelAndView.getViewName().endsWith("login")) {
            TbUser user= (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if(user!=null){
                // 已经登陆过则直接重定向到首页不再显示登录页
                httpServletResponse.sendRedirect("/main");
            }

        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
