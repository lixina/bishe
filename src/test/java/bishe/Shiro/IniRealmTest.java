package bishe.Shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.junit.Test;

public class IniRealmTest {
	@Test
	public void testIniRealm() {
		IniRealm inirealm = new IniRealm("classpath:user.ini");
		//1.构建SecurityManager环境
	DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
	defaultSecurityManager.setRealm(inirealm);	
	//主体提交认证请求
	SecurityUtils.setSecurityManager(defaultSecurityManager);
	org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	UsernamePasswordToken token = new UsernamePasswordToken("lixin","123456");
	subject.login(token);
	System.out.println("isAuthenticated:"+subject.isAuthenticated());
	//授权
	subject.checkRole("admin");
	//权限
	subject.checkPermission("user:delete");
	}
}
