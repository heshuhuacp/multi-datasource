package com.example.demo.mapper.slave;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SlaveUserMapper {

	Map<String,String> getUserAccountByUserId(Integer userId);
}