package com.example.tenantStudies.tenant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {

    private final Map<Object, Object> dataSources = new LinkedHashMap<>();

    public Map<Object, Object> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, Map<String, String>> dataSources) {
        dataSources
                .forEach((key, value) -> this.dataSources.put(key, convert(value)));
    }

    private DataSource convert(Map<String, String> source) {
        return DataSourceBuilder.create()
                .url(source.get("url"))
                .driverClassName(source.get("driver-class-name"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}