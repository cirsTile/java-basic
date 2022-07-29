package com.example.mysqlreadwriteseparation.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * @Description:
 * 在这里切换数据源的的读写模式
 * 原理是利用ThreadLocal保存当前线程是否处于读模式（通过开始READ_ONLY注解在开始操作前设置模式为读模式，
 * 操作结束后清除该数据，避免内存泄漏，同时也为了后续在该线程进行写操作时任然为读模式
 * 如果没有注解，则表示使用写模式。使用ReadOnly表示读模式
 * @Author: PanYi
 * @Date: 2022/7/27
 */
@Slf4j
public class DbContextHolder {
    public static final String WRITE = "masterDB";
    public static final String READ = "slaveDB";
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDbType(String dbType) {
        if (dbType == null) {
            log.error("dbType is null");
            throw new NullPointerException("dbType is null");
        }
        log.info("setDbType: {}", dbType);
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDbType() {
        return CONTEXT_HOLDER.get() == null ? WRITE : CONTEXT_HOLDER.get();
    }

    /**
     * @Description: 清除当前线程的数据源类型,避免内存泄露
     */
    public static void clearDbType() {
        CONTEXT_HOLDER.remove();
    }
}
