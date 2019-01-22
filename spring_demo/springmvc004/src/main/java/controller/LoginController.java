package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/showLogin")
    public ModelAndView showLogin(){
        System.out.println("adadadad");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping("/login")
    public ModelAndView login(String username,String password){
        ModelAndView mav = new ModelAndView();
        if("admin".equals(username) && "123".equals(password)){
            mav.addObject("username",username);
            mav.setViewName("success");
        }else{
            mav.addObject("loginError","用户名或密码错误");
            mav.setViewName("login");
        }
        return mav;
    }
}
