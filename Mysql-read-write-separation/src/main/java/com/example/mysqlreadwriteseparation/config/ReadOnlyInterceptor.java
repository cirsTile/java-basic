package com.example.mysqlreadwriteseparation.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/27
 */
@Aspect
@Component
@Slf4j
public class ReadOnlyInterceptor implements Ordered {

    @Around("@annotation(readOnly)")
    public Object setReadOnly(ProceedingJoinPoint pjp, ReadOnly readOnly) throws Throwable {
        log.info("setReadOnly");
        try {
            DbContextHolder.setDbType(DbContextHolder.READ);
            return pjp.proceed();
        } finally {
            DbContextHolder.clearDbType();
            log.debug("清除threadLocal");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
