package com.pwx.hrmapp.controller;

import com.pwx.hrmapp.entity.Dept;
import com.pwx.hrmapp.service.HrmService;
import com.pwx.hrmapp.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 处理部门请求控制器
 * Created by peng on 2018/6/11.
 */
@Controller
public class DeptController extends HrmController {

    /**
     * 自动注入UserService
     * */
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    /**
     * 处理/login请求
     * */
    @RequestMapping(value="/dept/selectDept")
    public String selectDept(Model model, Integer pageIndex,
                             @ModelAttribute Dept dept){
        LOGGER.info("pageIndex = {}, dept = {}", pageIndex, dept);
        PageModel pageModel = new PageModel();
        LOGGER.info("getPageIndex = {}, getPageSize = {}, getRecordCount = {}",
                pageModel.getPageIndex(), pageModel.getPageSize(), pageModel.getRecordCount());
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<Dept> depts = hrmService.findDept(dept, pageModel);
        model.addAttribute("depts", depts);
        model.addAttribute("pageModel", pageModel);
        return "dept/dept";

    }

    /**
     * 处理删除部门请求
     * @param ids 需要删除的id字符串
     * @param mv mv
     * */
    @RequestMapping(value="/dept/removeDept")
    public ModelAndView removeDept(String ids, ModelAndView mv){
        // 分解id字符串
        String[] idArray = ids.split(",");
        for(String id : idArray){
            // 根据id删除部门
            hrmService.removeDeptById(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/dept/selectDept");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理添加请求
     * @param flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param dept  要添加的部门对象
     * @param mv mv
     * */
    @RequestMapping(value="/dept/addDept")
    public ModelAndView addDept(
            String flag,
            @ModelAttribute Dept dept,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            mv.setViewName("dept/showAddDept");
        }else{
            // 执行添加操作
            hrmService.addDept(dept);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/dept/selectDept");
        }
        // 返回
        return mv;
    }

    /**
     * 处理修改部门请求
     * @param flag 标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param dept 要修改部门的对象
     * @param mv mv
     * */
    @RequestMapping(value="/dept/updateDept")
    public ModelAndView updateDpet(
            String flag,
            @ModelAttribute Dept dept,
            ModelAndView mv){
        if(flag.equals("1")){
            // 根据id查询部门
            Dept target = hrmService.findDeptById(dept.getId());
            // 设置Model数据
            mv.addObject("dept", target);
            // 设置跳转到修改页面
            mv.setViewName("dept/showUpdateDept");
        }else{
            // 执行修改操作
            hrmService.modifyDept(dept);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/dept/selectDept");
        }
        // 返回
        return mv;
    }
}
