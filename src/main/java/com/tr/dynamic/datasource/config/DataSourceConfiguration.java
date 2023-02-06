package com.tr.dynamic.datasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taorun
 * @date 2022/12/16 16:44
 */
@Configuration
public class DataSourceConfiguration {
    private final static String DB1 = "db1";
    private final static String DB2 = "db2";

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Primary
    @Bean(value = DB1)
    @Qualifier(DB1)
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(value = DB2)
    @Qualifier(DB2)
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "routingDataSource")
    public AbstractRoutingDataSource routingDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2) {
        DynamicDataSourceRouter proxy = new DynamicDataSourceRouter();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put("db1", db1);
        targetDataSources.put("db2", db2);
        proxy.setDefaultTargetDataSource(db1);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

}
