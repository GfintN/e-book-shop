package by.it.academy.example.persistence.configure;

import by.it.academy.example.persistence.dao.util.MongoFactory;
import com.mongodb.MongoClient;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(value = "by.it.academy.enterprise.persistence.dao")
@EnableJpaRepositories
@PropertySource("classpath:application.properties")
public class PersistenceContext {

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    DataSource dataSourcePostgresAdmin() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("postgres.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("postgres.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("postgres.username.admin"));
        dataSourceConfig.setPassword(env.getRequiredProperty("postgres.password.admin"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean(destroyMethod = "close")
    DataSource dataSourcePostgresReviewer() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("postgres.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("postgres.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("postgres.username.reviewer"));
        dataSourceConfig.setPassword(env.getRequiredProperty("postgres.password.reviewer"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean(destroyMethod = "close")
    DataSource dataSourcePostgresAuthor() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("postgres.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("postgres.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("postgres.username.author"));
        dataSourceConfig.setPassword(env.getRequiredProperty("postgres.password.author"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean(destroyMethod = "close")
    DataSource dataSourcePostgresUsers() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("postgres.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("postgres.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("postgres.username.users"));
        dataSourceConfig.setPassword(env.getRequiredProperty("postgres.password.users"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean(destroyMethod = "close")
    DataSource dataSourcePostgresSystem() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("postgres.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("postgres.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("postgres.username.system"));
        dataSourceConfig.setPassword(env.getRequiredProperty("postgres.password.system"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAdmin(@Qualifier("dataSourcePostgresAdmin") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("by.it.academy.enterprise.entity.postgresql");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryReviewer(@Qualifier("dataSourcePostgresReviewer") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("by.it.academy.enterprise.entity.postgresql");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAuthor(@Qualifier("dataSourcePostgresAuthor") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("by.it.academy.enterprise.entity.postgresql");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryUsers(@Qualifier("dataSourcePostgresUsers") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("by.it.academy.enterprise.entity.postgresql");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySystem(@Qualifier("dataSourcePostgresSystem") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("by.it.academy.enterprise.entity.postgresql");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public MongoClient mongoClientAdmin() {
        return new MongoFactory().getMongoClient(env.getRequiredProperty("mongodb.username.admin"),env.getRequiredProperty("mongodb.password.admin"));
    }
    @Bean
    public MongoClient mongoClientSubAdmin() {
        return new MongoFactory().getMongoClient(env.getRequiredProperty("mongodb.username.sub.admin"),env.getRequiredProperty("mongodb.password.sub.admin"));
    }
    @Bean
    public MongoClient mongoClientUsers() {
        return new MongoFactory().getMongoClient(env.getRequiredProperty("mongodb.username.users"),env.getRequiredProperty("mongodb.password.users"));
    }
    @Bean
    public MongoClient mongoClientSystem() {
        return new MongoFactory().getMongoClient(env.getRequiredProperty("mongodb.username.system"),env.getRequiredProperty("mongodb.password.system"));
    }


}
