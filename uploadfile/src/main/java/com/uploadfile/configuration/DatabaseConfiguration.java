package com.uploadfile.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Database configuration
 * Use Hikari connection pool
 */
@Configuration
@EnableConfigurationProperties(value = {
        UploadFileProperties.class
})
public class DatabaseConfiguration {

    @Autowired
    private UploadFileProperties properties;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(100);
        config.setDriverClassName(properties.getDatabase().getDriverClassName());
        config.setJdbcUrl(properties.getDatabase().getJdbcUrl());
        config.setUsername(properties.getDatabase().getDbUser());
        config.setPassword(properties.getDatabase().getDbPassword());

        return new HikariDataSource(config);
    }

}
