package com.example.demo.mapper.master;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MasterUserMapper {
	
	Map<String,String> getUserByUserId(Integer userId);

}
