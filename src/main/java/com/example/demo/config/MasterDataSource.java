package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ConfigurationProperties(prefix = "master.datasource")
public class MasterDataSource extends DruidDataSource{

	private static final long serialVersionUID = 2058726267993587020L;
	
	@Autowired
	private Environment env;
    
    public void setPassword(String password) {
   
    	super.setPassword(password);
    }

}