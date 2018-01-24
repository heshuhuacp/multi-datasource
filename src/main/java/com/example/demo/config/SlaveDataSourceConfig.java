package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

/**
 * 功能描述：连接阿拉丁数据库
 * 
 * @author heshuhua343
 * @date com.paic.icore..damagecapture.mapper
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.slave", sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class SlaveDataSourceConfig {

	static final String _LOCATION = "classpath*:mybatis/slave/*.xml";

	@Bean(name = "slaveDataSource")
	public DataSource DataSource() {

		return new SlaveDataSource();
	}

	@Bean(name = "slaveTransactionManager")
	public DataSourceTransactionManager TransactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource,PageHelper pageHelper)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(_LOCATION));
		Interceptor[] plugins = new Interceptor[] { pageHelper };
		sessionFactory.setPlugins(plugins);
		return sessionFactory.getObject();
	}

	@Bean(name = "slaveSqlSessionTemplate")
	public SqlSessionTemplate masterSqlSessionTemplate(
			@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
