package com.pwx.hrmapp.controller;

import com.pwx.hrmapp.entity.User;
import com.pwx.hrmapp.service.HrmService;
import com.pwx.hrmapp.util.common.HrmConstants;
import com.pwx.hrmapp.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理用户请求控制器
 * Created by peng on 2018/6/10.
 */
@Controller
public class UserController extends HrmController {

    /**
     * 自动注入UserService
     */
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    /**
     * 处理登录请求
     * @param loginname  登录名
     * @param password 密码
     * @return 跳转的视图
     * */
    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("loginname") String loginname,
                              @RequestParam("password") String password,
                              HttpSession session,
                              ModelAndView mv){
        // 调用业务逻辑组件判断用户是否可以登录
        User user = hrmService.login(loginname, password);
        if(user != null){
            // 将用户保存到HttpSession当中
            session.setAttribute(HrmConstants.USER_SESSION, user);
            // 客户端跳转到main页面
            mv.setViewName("redirect:/main");
        }else{
            // 设置登录失败提示信息
            mv.addObject("message", "登录名或密码错误!请重新输入");
            // 服务器内部跳转到登录页面
            mv.setViewName("forward:/loginForm");
        }
        return mv;
    }

    /**
     * 处理查询请求
     * @param pageIndex 请求的是第几页
     * @param user 模糊查询参数
     * @param model model
     * */
    @RequestMapping(value="/user/selectUser")
    public String selectUser(Integer pageIndex,
                             @ModelAttribute User user,
                             Model model){
        LOGGER.info("user = {}", user);
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<User> users = hrmService.findUser(user, pageModel);
        model.addAttribute("users", users);
        model.addAttribute("pageModel", pageModel);
        return "user/user";

    }

    /**
     * 处理删除用户请求
     * @param ids 需要删除的id字符串
     * @param mv mv
     * */
    @RequestMapping(value="/user/removeUser")
    public ModelAndView removeUser(String ids,ModelAndView mv){
        // 分解id字符串
        String[] idArray = ids.split(",");
        for(String id : idArray){
            // 根据id删除员工
            hrmService.removeUserById(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/user/selectUser");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理修改用户请求
     * @param flag 标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param user  要修改用户的对象
     * @param mv mv
     * */
    @RequestMapping(value="/user/updateUser")
    public ModelAndView updateUser(
            String flag,
            @ModelAttribute User user,
            ModelAndView mv){
        if(flag.equals("1")){
            // 根据id查询用户
            User target = hrmService.findUserById(user.getId());
            // 设置Model数据
            mv.addObject("user", target);
            // 返回修改员工页面
            mv.setViewName("user/showUpdateUser");
        }else{
            // 执行修改操作
            hrmService.modifyUser(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }

    /**
     * 处理添加请求
     * @param flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param user  要添加用户的对象
     * @param mv mv
     * */
    @RequestMapping(value="/user/addUser")
    public ModelAndView addUser(
            String flag,
            @ModelAttribute User user,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            System.out.println("addUser 11111111111");
            LOGGER.info("addUser: {}", user.toString());
            mv.setViewName("user/showAddUser");
        }
        else
        {
            // 执行添加操作
            System.out.println("addUser 222222222222");
            hrmService.addUser(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }
}
