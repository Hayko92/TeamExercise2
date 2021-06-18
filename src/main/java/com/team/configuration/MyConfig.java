package com.team.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.team")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
   public DataSource dataSource() {
        ComboPooledDataSource dataSource  =new ComboPooledDataSource();
        try{


            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("postgres://pjwndmxsggmmts:fc7efc2f06e4837d181e3e6e8b808cd5abf310f98a5e885112de9faaed457252@ec2-3-234-22-132.compute-1.amazonaws.com:5432/d53au5o3nl890v");
            dataSource.setUser("pjwndmxsggmmts");
            dataSource.setPassword("fc7efc2f06e4837d181e3e6e8b808cd5abf310f98a5e885112de9faaed457252");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;

    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.team.entity");
        Properties properties  =new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;


    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());

        return transactionManager;
    }


}
