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
		// ����SecurityManager����
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);
		// �����ύ��֤����
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lixin","123456");
		subject.login(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		// ��Ȩ
		subject.checkRole("admin");
	
	}
}
