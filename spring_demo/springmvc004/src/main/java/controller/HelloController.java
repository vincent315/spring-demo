package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest req,
                                      HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","Hello "+name);
        mav.setViewName("hello");
        return mav;
    }
}
