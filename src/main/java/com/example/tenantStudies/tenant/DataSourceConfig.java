package com.example.tenantStudies.tenant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource getDataSource() {
        TenantAwareRoutingDataSource tenantAwareRoutingDataSource = new TenantAwareRoutingDataSource();
        tenantAwareRoutingDataSource.setTargetDataSources(dataSourceProperties.getDataSources());
        tenantAwareRoutingDataSource.afterPropertiesSet();
        return tenantAwareRoutingDataSource;
    }
}