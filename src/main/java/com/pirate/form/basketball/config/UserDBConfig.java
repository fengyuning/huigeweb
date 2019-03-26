package com.pirate.form.basketball.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.pirate.form.basketball.dao.userDb", sqlSessionFactoryRef = "userDbSqlSessionFactory")
@PropertySource("classpath:config/${spring.profiles.active}/jdbc.properties")
public class UserDBConfig {
    @Autowired
    private Environment env;

    /**
     * 创建数据源
     */
    @Bean
    public DataSource userDbDataSource() throws Exception {
        Properties props = new Properties();
        props.put("url", env.getProperty("jdbc.user_db.url"));
        props.put("username", env.getProperty("jdbc.user_db.username"));
        props.put("password", env.getProperty("jdbc.user_db.password"));

        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
        props.put("minIdle", env.getProperty("spring.datasource.druid.minIdle"));
        props.put("maxActive", env.getProperty("spring.datasource.druid.maxActive"));
        props.put("maxWait", env.getProperty("spring.datasource.druid.max-wait"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    public SqlSessionFactory userDbSqlSessionFactory(
            @Qualifier("userDbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/userDb/*.xml"));
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }

}
