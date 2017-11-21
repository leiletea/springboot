package com.wenming.springboot.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wenming.springboot.entity.User;
import com.wenming.springboot.service.IUserService;

public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	private static final Logger logger = LoggerFactory.getLogger(AuthRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("---------------用户授权------------------");
		return null;
	}

	@Override
	public void setName(String name) {
		super.setName("authRealm");
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("---------------用户认证------------------");
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		String username = utoken.getUsername();
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(user, user.getPswd(), ByteSource.Util.bytes(user.getCredentialsSalt()),
				getName());// 放入shiro.调用CredentialsMatcher检验密码
	}

	// 清除缓存
	public void clearCached() {
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		AuthRealm userRealm = (AuthRealm) securityManager.getRealms().iterator().next();
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		userRealm.clearCache(principals);
	}

	public static void clearCachedAuthenticationInfo() {
		Subject subject = SecurityUtils.getSubject();
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		AuthRealm userRealm = (AuthRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
	}

	public static void clearCachedAuthorizationInfo() {
		Subject subject = SecurityUtils.getSubject();
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		AuthRealm userRealm = (AuthRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
	}

}
