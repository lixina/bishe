package com.etc.shiro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

	public class myRealm extends AuthorizingRealm{
		// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取认证信息中的用户名
		String username = (String) token.getPrincipal();
		String password = getPasswordByUsername(username);
		if(password == null){
			return null;
		}
		// 第三个参数是realm，即当前realm的名称
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo
				(username, password,getName());
		System.out.println(getName());
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("salt"));//加盐
		return authenticationInfo;
	}
	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		Set<String> roles = getRolesByUsername(username);
		Set<String> permissions = getPermissionsByUsername();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setStringPermissions(permissions);
		simpleAuthorizationInfo.setRoles(roles);
		return simpleAuthorizationInfo;
	}
	/**
	 * 模拟数据库
	 * @return
	 */
	Map<String,String> userMap = new HashMap<String, String>();
	{
		userMap.put("lixin", "f51703256a38e6bab3d9410a070c32ea");
		super.setName("myRealm");
	}
	/**
	 * 模拟数据库操作
	 * @return
	 */
	private Set<String> getPermissionsByUsername() {
		Set<String> sets = new HashSet<String>();
		sets.add("admin:delete");
		sets.add("user:look");
		sets.add("user:add");
		return sets;
	}
	/**
	 * 模拟数据库操作
	 * @return
	 */
	private Set<String> getRolesByUsername(String username) {
		Set<String> sets = new HashSet<String>();
		sets.add("admin");
		sets.add("user");
		return sets;
	}

	
	/**
	 * 模拟数据库查询
	 * @param usernamename
	 * @return
	 */
	private String getPasswordByUsername(String username) {
		return userMap.get(username);
	}
	/**
	  生成md5密文
	 @param args
	 */
	public static void main(String[] args) {
		Md5Hash md5Hash = new Md5Hash("123456","salt");
		System.out.println(md5Hash.toString());
	}

}
