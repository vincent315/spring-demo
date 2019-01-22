package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/path")
public class PathController {
    @RequestMapping("/showLogin")
    public String showLogin(){
        System.out.println("PathController.showLogin");
        return "login";
    }
    @RequestMapping("/forwardLogin")
    public String forwardLogin(){
        System.out.println("PathController.forwardLogin");
        return "forward:showLogin";//加/表示绝对路径，不加表示相对路径
    }
    /**
     * Ant风格
     */
    @RequestMapping("/test1/*")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/test2/**")
    public String test2(){
        System.out.println("PathController.test2");
        return "hello";
    }
    @RequestMapping("/test3/?")
    public String test3(){
        System.out.println("PathController.test3");
        return "hello";
    }

    @RequestMapping("/test4/?/aa/*/**")
    public String test4(){
        System.out.println("PathController.test4");
        return "hello";
    }
    @RequestMapping("/test5/{id}")
    public String test5(@PathVariable String id){//参数来源于URL
        System.out.println("PathController.test5" + id);
        return "hello";
    }

    /**
     * 限定请求方式
     * @return
     */
    @RequestMapping(value = "/test7",method = RequestMethod.GET)
    public String test7(){
        System.out.println("PathController.test7");
        return "hello";
    }
    /*
    其他属性
     */
    @RequestMapping(value = "/test8",params = {"id","username=admin","password=123"})
    public String test8(){
        System.out.println("PathController.test8");
        return "hello";
    }

    @RequestMapping(value = "/test8",headers = {"Cookie"})
    public String test9(){
        System.out.println("PathController.test9");
        return "hello";
    }


}
