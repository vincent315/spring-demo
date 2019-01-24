package com.xzy.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
// 申明是个spring管理的bean
@Component
@Log4j
public class LogAspectServiceApi {
    private JSONObject jsonObject = new JSONObject();
    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.xzy.controller.*.*(..))")
    private void controllerAspect() {
    }
//    @Before("execution(* com.xzy.controller.*.test(..))")
    @Before(value = "controllerAspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("......前置通知......");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============请求内容===============");
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
        log.info("===============请求内容===============");
    }

    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void after(Object o){
        System.out.println(".......后置通知......");
        log.info("--------------返回内容----------------");
        try {
            log.info("Response内容:" + jsonObject.toJSONString(o));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
        }
        log.info("--------------返回内容----------------");

    }


}
