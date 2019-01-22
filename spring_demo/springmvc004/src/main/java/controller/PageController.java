package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转转发
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{pageName}")
    public String go(@PathVariable String pageName){
        return pageName;
    }
}
