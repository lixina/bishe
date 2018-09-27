package bishe.Shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.junit.Before;
import org.junit.Test;

public class AuthorizerTest {
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
	@Before
	public void addUser(){
		simpleAccountRealm.addAccount("lixin", "123456","admin");
	}
	@Test
	public void testAuthentication() {
		// 构建SecurityManager环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);
		// 主体提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lixin","123456");
		subject.login(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		// 授权
		subject.checkRole("admin");
	
	}
}
