package com.lwj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwj.bean.User;
import com.lwj.exception.CustomException;
import com.lwj.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	protected final Logger log =LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/test")
	public String Index(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        log.info("成功");
        return "user";
    }
	/**
     * 分页查询
	 * @throws CustomException 
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public @ResponseBody PageInfo<User> pageList(ModelMap map,@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) throws CustomException{
    	
        Integer pageSize=4;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = userService.list();//获取所有用户信息
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        map.addAttribute("pageInfo", pageInfo);
        if(1 == 1){
        	throw new CustomException("商品的修改信息不存在!");
        }
        return pageInfo;
    }

	@RequestMapping("/aaa")
	public @ResponseBody String test(){
		userService.deleteById();
        return "删除成功";
    }
}
