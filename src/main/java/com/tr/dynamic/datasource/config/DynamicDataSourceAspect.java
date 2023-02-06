package com.tr.dynamic.datasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author taorun
 * @date 2022/12/16 16:52
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

//    @Pointcut("execution(* com.tr.dynamic.datasource.controller.DataSourceController.changeDataSource(..))" +
//            "|| execution(* com.tr.dynamic.datasource.controller.UserController.*(..))")
//    private void aspect() {}

    @Pointcut("execution(* com.tr.dynamic.datasource.controller.DataSourceController.changeDataSource(..))")
    private void aspect() {}

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
//        DataSourceContextHolder.setDataSource((String) args[0]);
        DataSourceContextHolder.defaultDbKey = (String) args[0];
    }
}
