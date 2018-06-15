package com.pwx.hrmapp.interceptor;

import com.pwx.hrmapp.entity.User;
import com.pwx.hrmapp.util.common.HrmConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断用户权限的Spring MVC的拦截器
 * Created by peng on 2018/6/10.
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    // 定义不需要拦截的请求
    private static final String[] IGNORE_URI = {"/loginForm", "/login", "/404"};

    /**
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
     * 当preHandle的返回值为false的时候整个请求就结束了。
     * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
     * @param request request
     * @param response response
     * @param o object
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {

        LOGGER.info("RemoteHost: {} , RequestURL: {}", request.getRemoteHost(), request.getRequestURL());

        // 默认用户没有登录
        boolean flag = false;
        // 获得请求的ServletPath
        String servletPath = request.getServletPath();
        // 判断请求是否需要拦截
        for (String str : IGNORE_URI) {
            if (servletPath.contains(str)) {
                flag = true;
                break;
            }
        }

        // 拦截请求
        if (!flag) {
            User user = (User) request.getSession().getAttribute(HrmConstants.USER_SESSION);
            if (user == null) {
                request.setAttribute("message", "请先登录再访问网站!");
                request.getRequestDispatcher(HrmConstants.LOGIN).forward(request, response);
                return flag;
            } else {
                flag = true;
            }
        }

        return flag;
    }

    /**
     * 这个方法在preHandle方法返回值为true的时候才会执行。
     * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o object
     * @param modelAndView modelAndView
     * @throws Exception Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法需要preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o object
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
