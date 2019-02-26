package bishe.Shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;


public class jdbcRealmTest {
	DruidDataSource dataSource = new DruidDataSource();
	{
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}
		@Test
	public void testjdbcRealm(){
		JdbcRealm jdbcRealm = new JdbcRealm();
	    jdbcRealm.setDataSource(dataSource);
	    // 设置权限开关
	    jdbcRealm.setPermissionsLookupEnabled(true);
	    // 不写查询语句有默认的查询语句（数据库中的表与默认的表相同）
	    String sql = "select password from user_defined where username = ?";
	    jdbcRealm.setAuthenticationQuery(sql);
	    
	    
	    //1.构建SecurityManager环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(jdbcRealm);	
		
		//主体提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lixin","123456");
		subject.login(token);
		System.out.println(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		
		//授权
		try {
			subject.checkRole("admin");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//权限
		try {
			subject.checkPermission("user:delete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
