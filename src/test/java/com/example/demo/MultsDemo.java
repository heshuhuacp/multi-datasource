package com.example.demo;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mapper.master.MasterUserMapper;
import com.example.demo.mapper.slave.SlaveUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultsDemo {
	
	private Logger logger = LoggerFactory.getLogger(MultsDemo.class);
	
	@Autowired
	private MasterUserMapper masterUserMapper;
	@Autowired
	private SlaveUserMapper slaveUserMapper;

	@Test
	public void multiDataSource() {
		
		int userId = 1;
		Map<String,String> user = masterUserMapper.getUserByUserId(userId);
		logger.info("---------->user={}",user);
		Map<String,String> userAccount = slaveUserMapper.getUserAccountByUserId(userId);
		logger.info("---------->userAccount={}",userAccount);
	}

}
