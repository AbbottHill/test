package com.cd.test.config;

import com.cd.test.utils.Constants;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.session.*;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;

@Configuration
//导入属性文件
@PropertySource("classpath:config.properties")
//相当于 xml 中的 <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
//定义Spring MVC扫描的包
@ComponentScan("com.cd.test")
//spring-mybatis mapper scan
@MapperScan("com.cd.test.maintain")
//启动Spring MVC配置
@EnableWebMvc
public class RootConfig {

    /**
     * 上面导入的属性文件中的属性会 注入到 Environment 中
     */
    @Resource
    private Environment env;

    public static Map<String, String> configProperties = new HashMap<>();

    /**
     * 配置数据库连接池 c3p0，
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(env.getProperty("db.url"));
        dataSource.setDriverClass(env.getProperty("db.driver"));
        dataSource.setUser(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setMinPoolSize(Integer.valueOf(env.getProperty("pool.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.valueOf(env.getProperty("pool.maxPoolSize")));
        dataSource.setAutoCommitOnClose(false);
        dataSource.setCheckoutTimeout(Integer.valueOf(env.getProperty("pool.checkoutTimeout")));
        dataSource.setAcquireRetryAttempts(2);

        //set config todo
        configProperties.put(Constants.VERSION, env.getProperty("resource_version"));

        return dataSource;
    }

    /**
     * 配置事物管理器
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * mybatis sqlSessionFactoryBean
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory (DataSource dataSource) {
//        LogFactory.useLog4J2Logging();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Log4j2Impl.class);
        System.out.println("configuration.getLogImpl ---> " + configuration.getLogImpl());

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

}
    