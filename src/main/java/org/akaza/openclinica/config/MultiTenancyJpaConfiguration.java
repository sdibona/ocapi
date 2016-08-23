package org.akaza.openclinica.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.akaza.openclinica.domain.datamap.StudySubject;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableConfigurationProperties(JpaProperties.class)
public class MultiTenancyJpaConfiguration {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private MultiTenantConnectionProvider multiTenantConnectionProvider;

	@Autowired
	private CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, Object> hibernateProps = new LinkedHashMap<>();
		hibernateProps.putAll(jpaProperties.getHibernateProperties(dataSource));

		hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
		hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
		hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
		hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProps.put("hibernate.cache.use_second_level_cache","false");
		hibernateProps.put("hibernate.cache.use_query_cache","false");
		//hibernateProps.put("hibernate.cache.region.factory_class", "net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory");

		//return builder.dataSource(dataSource).packages("org.akaza.openclinica.domain").properties(hibernateProps).jta(false).build();
		return builder.dataSource(dataSource).packages(StudySubject.class.getPackage().getName()).properties(hibernateProps).jta(false).build();
	}
}
