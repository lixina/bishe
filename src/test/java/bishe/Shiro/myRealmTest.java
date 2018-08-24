package bishe.Shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.junit.Test;

import com.etc.shiro.myRealm;

public class myRealmTest {
	myRealm myrealm = new myRealm();
	@Test
	public void testAuthentication() {
		//1.构建SecurityManager环境
	DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
	defaultSecurityManager.setRealm(myrealm);
	
	HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
	matcher.setHashAlgorithmName("md5");
	matcher.setHashIterations(1);//加密次数
	myrealm.setCredentialsMatcher(matcher);
	
	
		//主体提交认证请求
	SecurityUtils.setSecurityManager(defaultSecurityManager);
	org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	UsernamePasswordToken token = new UsernamePasswordToken("lixin","12345");
	try {
		subject.login(token);
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("isAuthenticated:"+subject.isAuthenticated());
	try {
		subject.checkRole("user");
		subject.checkRole("admin");
		subject.checkPermissions("admin:delete");
		subject.checkPermissions("user:add");
	} catch (Exception e) {
		e.printStackTrace();
	}
	subject.logout();
	}
}
