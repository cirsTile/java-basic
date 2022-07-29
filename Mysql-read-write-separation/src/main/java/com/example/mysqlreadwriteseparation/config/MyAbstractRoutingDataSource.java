package com.example.mysqlreadwriteseparation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description:
 * spring 在开始进行数据库操作时会通过这个方法来决定使用哪个数据库，
 * 因此我们在这里调用上面 DbContextHolder 类的getDbType()方法获取当前操作类别,同时可进行读库的负载均衡
 * @Author: PanYi
 * @Date: 2022/7/27
 */
@Slf4j
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String dbType = DbContextHolder.getDbType();
        if (dbType == DbContextHolder.WRITE) {
            log.info("使用主库{}", dbType);
            return dbType;
        }
        log.info("使用从库{}", dbType);
        return DbContextHolder.getDbType();
    }
}
