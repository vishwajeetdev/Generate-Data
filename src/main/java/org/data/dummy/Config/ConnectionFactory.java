package org.data.dummy.Config;

import com.zaxxer.hikari.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.*;
import org.springframework.cloud.config.java.*;
import org.springframework.context.annotation.*;


import javax.sql.DataSource;

@Configuration
@Profile("cloud")
@RequiredArgsConstructor
public class ConnectionFactory extends AbstractCloudConfig {

    private final HanaConfig hanaConfig;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(com.sap.db.jdbc.Driver.class.getName())
                .url(hanaConfig.getUrl())
                .username(hanaConfig.getUsername())
                .password(hanaConfig.getPassword())
                .build();
    }
}
