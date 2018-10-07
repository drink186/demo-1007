package com.example.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;

public class ShiroRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;//用户业务类
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//从合法身份信息中合法用户名
		String account = (String) principals.getPrimaryPrincipal();
		//从业务层读取合法用户信息
		User user = userService.findByAccount(account);
		//授权：得到权限信息
		for (Role role : user.getRoleList()) {
			authorizationInfo.addRole(role.getName());//授予角色
			for (Permission p : role.getPermissionList()) {
				authorizationInfo.addStringPermission(p.getName());//授予权限
			}
		}
		return authorizationInfo;
	}
    /**
     * 身份认证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从token中读取登录名和密码
		UsernamePasswordToken login = (UsernamePasswordToken) token;
		String account = login.getUsername();
		String pass = new String(login.getPassword());
		//从业务层读取用户信息
		User user = userService.findByAccount(account);
		//判断用户是否存在
		if (user == null) {
			throw new AuthenticationException("用户不存在");
		}
		//判断密码是否正确
		String password = user.getPassword();
		if (!pass.equals(password)) {
			throw new AuthenticationException("密码错误");
		}
		//身份认证：将数据库里读取的登录名和密码与token中的用户名和密码进行比较，得到身份信息。
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(account, password, getName());
		return info;
	}

}
