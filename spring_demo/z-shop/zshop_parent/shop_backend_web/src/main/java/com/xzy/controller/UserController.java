package com.xzy.controller;

import com.xzy.Exception.SysuserExistException;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.MD5SaltUtil;
import com.xzy.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/regist")
    public String regist(@Valid UserVo userVo, Errors errors){
//    public String regist(UserVo userVo, Errors errors){
        //手动进行服务端数据校验
        //if(userVo.getAge()<0|| userVo.getAge()>120){
        //    errors.reject("年龄只能在0-120之间"); //手动添加错误消息
        //}

        //判断是否有错误
        if(errors.hasErrors()){
            System.out.println(errors);//服务端校验的错误消息一般只在后台处理
            return "regist";
        }
        //没有错误，可以注册
        String password = userVo.getPassword();
        String newPassword = MD5SaltUtil.md5Salt(password);
       Date data = new Date();
        User sysuser = new User(userVo.getUsername(),newPassword,userVo.getPhone(),userVo.getEmail(),data,data);
        try {
            userService.insertUser(sysuser);
        } catch (SysuserExistException e) {
            e.printStackTrace();
            return "regist";
        }
        return "success";
    }
}
