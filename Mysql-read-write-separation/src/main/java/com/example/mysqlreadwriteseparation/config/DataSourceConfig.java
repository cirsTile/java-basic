package com.example.mysqlreadwriteseparation.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数据源配置，配置主库和从库
 * @Author: PanYi
 * @Date: 2022/7/27
 */
@Configuration
@MapperScan(basePackages = "com.example.mysqlreadwriteseparation.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Value("${spring.mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${spring.mybatis.mapper-locations}")
    private String mapperLocation;

    /**
     * @Description: 主库数据源
     * @return
     */
    @Bean(name = "masterDB", autowireCandidate = true)
    @ConfigurationProperties(prefix = "spring.master.datasource")//数据库配置读取前缀
    public DataSource dataSourceMaterDB() {
        return DataSourceBuilder.create().build();
    }


    /**
     * @Description: 从库数据源
     * @return
     */
    @Bean(name = "slaveDB", autowireCandidate = true)
    @ConfigurationProperties(prefix = "spring.slave.datasource")//数据库配置读取前缀
    public DataSource dataSourceSlaveDB() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 设置数据源路由，通过该类中的determineCurrentLookupKey决定使用哪个数据源
     * @return
     */
    @Bean
    public MyAbstractRoutingDataSource routingDataSource() {
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DbContextHolder.WRITE, dataSourceMaterDB());
        targetDataSources.put(DbContextHolder.READ, dataSourceSlaveDB());
        proxy.setDefaultTargetDataSource(dataSourceMaterDB());
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    /**
     * 多数据源需要自己设置sqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(routingDataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 实体类对应的位置
        bean.setTypeAliasesPackage(typeAliasesPackage);
        // mybatis的XML的配置
        bean.setMapperLocations(resolver.getResources(mapperLocation));
        return bean.getObject();
    }

    /**
     * 设置事务，事务需要知道当前使用的是哪个数据源才能进行事务处理
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(routingDataSource());
    }
}
