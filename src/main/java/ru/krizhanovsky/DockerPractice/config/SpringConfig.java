package ru.krizhanovsky.DockerPractice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.krizhanovsky.DockerPractice")
@EnableWebMvc
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class SpringConfig {

    private final String url;
    private final String username;
    private final String password;
    private final String connectorClasspath;

    public SpringConfig(@Value("${database.connect.url}") String url,
                        @Value("${database.connect.username}") String username,
                        @Value("${database.connect.password}") String password,
                        @Value("${database.connect.connector.classpath}") String connectorClasspath) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.connectorClasspath = connectorClasspath;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(connectorClasspath);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.krizhanovsky.DockerPractice.entity");
        sessionFactory.setHibernateProperties(properties());
        return sessionFactory;
    }

    public Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
