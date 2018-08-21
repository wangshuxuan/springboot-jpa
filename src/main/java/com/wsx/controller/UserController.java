package com.wsx.controller;

import com.wsx.entity.User;
import com.wsx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/20 10:07
 * User控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }

    @RequestMapping(value = "/saveOrUpdate")
    @ResponseBody
    public String add( User user) {
        int id = userService.save(user);
        if (id > 0 ) {
            return id + "";
        }
        else return "新增失败";
    }

    @RequestMapping(value = "/delete/{Id}")
    @ResponseBody
    public String delete(@PathVariable int Id) {
        boolean b = userService.deleteById(Id);
        if (b) return "删除成功";
        else return "删除失败";
    }

    @RequestMapping(value = "listAll")
    @ResponseBody
    public List<User> listAll() {
        List<User> users = userService.listAll();
        return users;
    }
}
