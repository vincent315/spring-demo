package com.xzy.controller;

import com.xzy.Exception.SysuserExistException;
import com.xzy.constant.ResponseStatusConstant;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.MD5SaltUtil;
import com.xzy.utils.ResponseResult;
import com.xzy.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/regist")
    public String regist(@Valid UserVo userVo, Errors errors){
        //判断是否有错误
        if(errors.hasErrors()){
            System.out.println(errors);//服务端校验的错误消息一般只在后台处理
            return "regist";
        }
        //没有错误，可以注册
        String password = userVo.getPassword();
        String newPassword = MD5SaltUtil.md5Salt(password);
        User user = new User(userVo.getUsername(),newPassword,userVo.getPhone(),userVo.getEmail(),new Date(),new Date());
        try {
            userService.insertUser(user);
        } catch (SysuserExistException e) {
            e.printStackTrace();
            return "regist";
        }
        return "success";
    }


    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(String username, String password){
        System.out.println(username);
        System.out.println(password);
            ResponseResult responseResult = new ResponseResult();
            User user = userService.selectByName(username);
            if(user == null){
                responseResult  = ResponseResult.failed("该用户不存在");
            return responseResult;
        }
        String md5Pwd = user.getPassword();
        if(MD5SaltUtil.verify(password,md5Pwd)){
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
            responseResult.setMessage("登录成功");
            responseResult.setData(user);
        }else{
            responseResult= ResponseResult.failed("密码输入错误");
        }
        return responseResult;
    }
}
