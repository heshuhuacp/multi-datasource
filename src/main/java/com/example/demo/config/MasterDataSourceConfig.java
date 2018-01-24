package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@MapperScan(basePackages = "com.example.demo.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDataSourceConfig {

	static final String _LOCATION = "classpath*:mybatis/master/*.xml";

	@Bean(name = "masterDataSource")
	@Primary
	public DataSource DataSource() {

		return new MasterDataSource();
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager TransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory SqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource,PageHelper pageHelper)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(_LOCATION));
		Interceptor[] plugins = new Interceptor[] { pageHelper };
		sessionFactory.setPlugins(plugins);
		return sessionFactory.getObject();
	}

	@Bean(name = "masterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate masterSqlSessionTemplate(
			@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
