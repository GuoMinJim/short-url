package cn.pzhu.shorturl.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
public class DefenceAspect {

  @Pointcut("execution(public * cn.pzhu.shorturl.controller.UrlController..*.*(..))")
  public void test(){
    System.out.println("aaaa");
  }

  @Before("test()")
  public void beforeDo(){
    System.out.println("before...");
  }

}
