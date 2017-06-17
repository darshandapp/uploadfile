package com.uploadfile.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Store all upload config from resources/application.properties
 */
@ConfigurationProperties("spring.uploadfile")
@Getter
@Setter
public class UploadFileProperties {
    private String path;
    private DataBase database;

    public DataBase getDatabase() {
        return database;
    }

    public void setDatabase(DataBase database) {
        this.database = database;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Setter
    @Getter
    public static class DataBase {
        private String driverClassName;
        private String jdbcUrl;
        private String dbUser;
        private String dbPassword;
    }

}
