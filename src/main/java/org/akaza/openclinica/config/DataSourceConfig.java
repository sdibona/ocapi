package org.akaza.openclinica.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Autowired
	private MultitenancyProperties multitenancyProperties;

	@Bean(name = { "dataSource", "dataSource1" })
	@ConfigurationProperties(prefix = "spring.ocapi.datasource1")
	public DataSource dataSource1() {

/*
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		config.setMaximumPoolSize(20);
		config.addDataSourceProperty("user","rdtiyxwfvijryp");
		config.addDataSourceProperty("password","q7MMW8APNYWwEO50Mtg06KQRQQ");
		config.addDataSourceProperty("databaseName", "d3q1fuums76hmk");
		config.addDataSourceProperty("serverName", "ec2-54-235-120-118.compute-1.amazonaws.com");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
*/

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(this.multitenancyProperties.getDatasource1().getUrl());
		config.setUsername(this.multitenancyProperties.getDatasource1().getUsername());
		config.setPassword(this.multitenancyProperties.getDatasource1().getPassword());
		config.setMaximumPoolSize(20);
		HikariDataSource ds = new HikariDataSource(config);
		return ds;

		/*
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource1().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource1().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource1().getUsername())
				.password(this.multitenancyProperties.getDatasource1().getPassword())
				.url(this.multitenancyProperties.getDatasource1().getUrl());
		return factory.build();
		*/
	}
/*
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource2")
	public DataSource dataSource2() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource2().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource2().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource2().getUsername())
				.password(this.multitenancyProperties.getDatasource2().getPassword())
				.url(this.multitenancyProperties.getDatasource2().getUrl());
		return factory.build();
	}

	@Bean(name = "dataSource3")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource3")
	public DataSource dataSource3() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource3().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource3().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource3().getUsername())
				.password(this.multitenancyProperties.getDatasource3().getPassword())
				.url(this.multitenancyProperties.getDatasource3().getUrl());
		return factory.build();
	}
	*/
}
