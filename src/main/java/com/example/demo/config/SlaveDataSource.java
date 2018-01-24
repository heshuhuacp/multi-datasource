package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ConfigurationProperties(prefix = "slave.datasource")
public class SlaveDataSource extends DruidDataSource{

	private static final long serialVersionUID = 2058726267993587020L;
    
    public void setPassword(String password) {
   
    	super.setPassword(password);
    }

}