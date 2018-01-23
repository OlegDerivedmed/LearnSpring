package com.belkin.config;

import com.belkin.dao.UserDao;
import com.belkin.dao.UserDaoImpl;
import com.belkin.service.TestBean;
import com.belkin.service.UserService;
import com.belkin.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public TestBean getBean(){
        return new TestBean("hello!");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDatasource());
    }
    @Bean
    public DataSource getDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/learning?useSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Nihuyatakoiparo1");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(getUserDao());
    }
}
