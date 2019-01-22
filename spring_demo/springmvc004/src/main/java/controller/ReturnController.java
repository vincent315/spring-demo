package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnController {

    @RequestMapping("/showLogin2")
    public String showLogin2(){
        System.out.println("转发了呀");
        return "login";//视图的名字
    }
    @RequestMapping("/login2")
    public String login2(String username, String password, Model model){//将数据存储到model对象中
        if("admin".equals(username) && "123".equals(password)){
            model.addAttribute("username",username);
            return "success";
        }else{
            model.addAttribute("loginError","username or password error");
//            return "login";
            return "forward:showLogin2";//转发
//            return "redirect:showLogin2";//重定向
        }
    }
}
