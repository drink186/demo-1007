package com.example.shiro;

import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="shiro")
public class ShiroChain extends ShiroFilterFactoryBean {
	private Map<String,String> filterChainDefinitionMap; //过滤规则：key-拦截路径，value-验证规则	
	private String loginUrl;          //登录路径
	private String successUrl;        //登陆成功后跳转路径
	private String unauthorizedUrl;   //登录失败后跳转路径

	public Map<String, String> getFilterChainDefinitionMap() {
		return filterChainDefinitionMap;
	}
	public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
		this.filterChainDefinitionMap = filterChainDefinitionMap;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getSuccessUrl() {
		return successUrl;
	}
	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}
	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}
	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}
	
}
