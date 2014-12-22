package no.nith.sivpal12.futurama.quotes.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "no.nith.sivpal12.futurama.quotes.controllers",
        "no.nith.sivpal12.futurama.quotes.services",
        "no.nith.sivpal12.futurama.quotes.repositories"
})
@EnableTransactionManagement
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder =
                new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("no.nith.sivpal12.futurama.quotes.entities")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        // https://devcenter.heroku.com/articles/heroku-postgresql#spring-java
        // URI dbUri = new URI(System.getenv("DATABASE_URL"));
        // String username = dbUri.getUserInfo().split(":")[0];
        // String password = dbUri.getUserInfo().split(":")[1];
        // String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':'
        // + dbUri.getPort() + dbUri.getPath();


        Properties prop = new Properties();
        prop.put(AvailableSettings.FORMAT_SQL, "true");
        prop.put(AvailableSettings.SHOW_SQL, "true");
        prop.put(AvailableSettings.DIALECT,
                "org.hibernate.dialect.PostgreSQL9Dialect");
        return prop;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/futurama-quotes");
        ds.setUsername("futurama-app");
        ds.setPassword("postgres");
        return ds;
    }

    // Create a transaction manager
    @Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

}
