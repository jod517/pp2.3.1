package testgroup.filmography.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "testgroup.filmography")
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
public class DbConfig {


    private final Environment environment;

    @Autowired
    public DbConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty("db.driver"));
        driverManagerDataSource.setUrl(environment.getProperty("db.url"));
        driverManagerDataSource.setUsername(environment.getProperty("db.username"));
        driverManagerDataSource.setPassword(environment.getProperty("db.password"));
        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        localContainerEntityManagerFactoryBean.setPackagesToScan(environment.getProperty("db.entitymanager.packages.to.scan"));

        Properties properties = new Properties();
        properties.put("hibernate.show_sql", environment.getProperty("db.hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("db.hibernate.hbm2ddl.auto"));

        localContainerEntityManagerFactoryBean.setJpaProperties(properties);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
}