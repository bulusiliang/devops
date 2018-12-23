package com.lq.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 类定义切面类
 */
@Aspect  // 使其标注为一个切面，切点为@Log注解标注的方法，使用@Around环绕通知
@Component
public class LogAspect {

    private long startTime;
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("@annotation(com.lq.component.annotation.Log)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 时长
        long time = System.currentTimeMillis() - beginTime;
        return result;
    }
}
