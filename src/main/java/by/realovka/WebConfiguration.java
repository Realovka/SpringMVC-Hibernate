package by.realovka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("by.realovka")
public class WebConfiguration {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/user?useUnicode=true&serverTimezone=UTC&useSSL=false");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/user?serverTimezone=UTC" );
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Vorobei55");
        return driverManagerDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("by.realovka.entity");
        localSessionFactoryBean.setHibernateProperties(hibProps());
        return localSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }

    public Properties hibProps(){
        Properties properties = new Properties();
////        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/user?serverTimezone=UTC" );
//////        properties.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/user?useUnicode=true&serverTimezone=UTC&useSSL=false");
//        properties.setProperty("dialect", "org.hibernate.dialect.MySQL");
//        properties.setProperty("hibernate.connection.username","root");
//        properties.setProperty("hibernate.connection.password","Vorobei55" );
//        properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        return properties;
    }

}
