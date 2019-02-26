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
	    // ����Ȩ�޿���
	    jdbcRealm.setPermissionsLookupEnabled(true);
	    // ��д��ѯ�����Ĭ�ϵĲ�ѯ��䣨���ݿ��еı���Ĭ�ϵı���ͬ��
	    String sql = "select password from user_defined where username = ?";
	    jdbcRealm.setAuthenticationQuery(sql);
	    
	    
	    //1.����SecurityManager����
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(jdbcRealm);	
		
		//�����ύ��֤����
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lixin","123456");
		subject.login(token);
		System.out.println(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		
		//��Ȩ
		try {
			subject.checkRole("admin");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//Ȩ��
		try {
			subject.checkPermission("user:delete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
