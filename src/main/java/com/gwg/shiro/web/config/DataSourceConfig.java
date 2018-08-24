package com.gwg.shiro.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * MyBatis基础配置
 * @author Administrator
 *
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig{

	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	@Value("${mysql.dbdriver}")
	private String driverClassName;
	@Value("${mysql.dburl}")
	private String dburl;
	@Value("${mysql.dbUserName}")
	private String username;
	@Value("${mysql.password}")
	private String password;
	@Value("${mysql.initSize}")
	private int initialSize;
	@Value("${mysql.maxActive}")
	private int maxActive;
	@Value("${mysql.minEvictableIdleTimeMillis}")
	private long minEvictableIdleTimeMillis;
	@Value("${mysql.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${mysql.testOnReturn}")
	private boolean testOnReturn;
	@Value("${mysql.validationQuery}")
	private String validationQuery;



	/**
	 * 
	 * @Title: 生成一个名字为  dataSource的bean
	 * @Description: 数据源的配置  
	 * @param: @return      
	 * @return: DataSource      
	 * @throws
	 */
	@Bean
    public DataSource dataSource() {
		logger.info("driverClassName:{}, dburl:{}, username:{}, password:{}", driverClassName, dburl, username, password);
        DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driverClassName);
		druidDataSource.setUrl(dburl);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setInitialSize(initialSize);
		druidDataSource.setMaxActive(maxActive);
		druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		druidDataSource.setTestOnBorrow(testOnBorrow);
		druidDataSource.setTestOnReturn(testOnReturn);
		druidDataSource.setValidationQuery(validationQuery);
		return druidDataSource;

	}

	/**
	 *
	 * @Title: transactionManager
	 * @Description: 配置事务管理器
	 * @param: @param dataSource
	 * @return: DataSourceTransactionManager 实现了PlatformTransactionManager接口
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource)
			throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

}
