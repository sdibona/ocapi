package org.akaza.openclinica.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties("spring.multitenancy")
public class MultitenancyProperties {

	@NestedConfigurationProperty
	private DataSourceProperties datasource1;

	@NestedConfigurationProperty
	private String attachedFileLocation;

	//@NestedConfigurationProperty
	//private DataSourceProperties datasource2;

	//@NestedConfigurationProperty
	//private DataSourceProperties datasource3;

	public DataSourceProperties getDatasource1() {
		return datasource1;
	}

	public void setDatasource1(DataSourceProperties datasource1) {
		this.datasource1 = datasource1;
	}

	//public DataSourceProperties getDatasource2() {
	//	return datasource2;
	//}

	//public void setDatasource2(DataSourceProperties datasource2) {
	//	this.datasource2 = datasource2;
	//}

	//public DataSourceProperties getDatasource3() {
	//	return datasource3;
	//}

	//public void setDatasource3(DataSourceProperties datasource3) {
	//	this.datasource3 = datasource3;
	//}


	public String getAttachedFileLocation() {
		return attachedFileLocation;
	}

	public void setAttachedFileLocation(String attachedFileLocation) {
		this.attachedFileLocation = attachedFileLocation;
	}
}