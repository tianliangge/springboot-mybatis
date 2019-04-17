package com.tian.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@ConditionalOnClass(DruidDataSource.class)//DruidDataSource必须有才能有效
@ConfigurationProperties(prefix="spring.datasource.druid")
public class DuridConfig {
	
	@Bean(initMethod="init")									
	@ConfigurationProperties(prefix="spring.datasource")
	public DruidDataSource getDruidDataSource() {
		return new DruidDataSource();
	}
//	@Value("${spring.datasource.druid.loginUsername}")
	private String loginUsername;
	private String loginPassword;
	private String allow;
	private String deny;
	private String exclusions;
	private String statViewServletUrlPattern;
	private String webStatFilterUrlPattern;
	
	
	/***监控配置开始 */
	/**
	 * 注册servlet
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> getStatViewServlet(){
		StatViewServlet  statViewServlet=new StatViewServlet();
		//创建注册器
		ServletRegistrationBean<StatViewServlet> registrationBean=new ServletRegistrationBean<>();
		//注册
		registrationBean.setServlet(statViewServlet);
		registrationBean.addInitParameter("loginUsername", loginUsername);
		registrationBean.addInitParameter("loginPassword", loginPassword);
		registrationBean.addInitParameter("allow",allow);
		registrationBean.addInitParameter("deny", deny);
		//添加url-patten
		registrationBean.addUrlMappings(statViewServletUrlPattern);
		
		return registrationBean;
		
	}
	
	
	/**
	 * 注册Filter
	 */
	@Bean
	public FilterRegistrationBean<WebStatFilter> getWebStatFilter(){
		WebStatFilter webStatFilter=new WebStatFilter();
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean=new FilterRegistrationBean<>();
		//注册
		filterRegistrationBean.setFilter(webStatFilter);
		filterRegistrationBean.addInitParameter("exclusions", exclusions);
		filterRegistrationBean.addUrlPatterns(webStatFilterUrlPattern);
		return filterRegistrationBean;
	}


	public String getLoginUsername() {
		return loginUsername;
	}


	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getAllow() {
		return allow;
	}


	public void setAllow(String allow) {
		this.allow = allow;
	}


	public String getDeny() {
		return deny;
	}


	public void setDeny(String deny) {
		this.deny = deny;
	}


	public String getExclusions() {
		return exclusions;
	}


	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}


	public String getStatViewServletUrlPattern() {
		return statViewServletUrlPattern;
	}


	public void setStatViewServletUrlPattern(String statViewServletUrlPattern) {
		this.statViewServletUrlPattern = statViewServletUrlPattern;
	}


	public String getWebStatFilterUrlPattern() {
		return webStatFilterUrlPattern;
	}


	public void setWebStatFilterUrlPattern(String webStatFilterUrlPattern) {
		this.webStatFilterUrlPattern = webStatFilterUrlPattern;
	}
	
	/***监控配置结束*/
	
	
}
