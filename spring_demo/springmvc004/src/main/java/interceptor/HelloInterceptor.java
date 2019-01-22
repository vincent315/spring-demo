package interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class HelloInterceptor implements HandlerInterceptor {
    //在调用目标处理方法之前执行，可以权限，日志等
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            Method method = ((HandlerMethod) handler).getMethod();
            System.out.println("HelloInterceptor.preHandle" + bean.getClass() + method.getName());
        }
        return true;//继续执行，调用后续的拦截器或者目标处理方法，false表示不再调用
    }
    //调用目标处理方法之后执行，渲染视图之前，可以对数据模型进行修改
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HelloInterceptor.postHandle");
    }
    //渲染视图之后，可以用来释放资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HelloInterceptor.afterCompletion");
    }
}
