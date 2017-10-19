package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.entity.User;

public class SpringHbnTestCase {
	ClassPathXmlApplicationContext ctx;
	SessionFactory factory;
	Session session;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
				"spring-pool.xml",
				"spring-hibernate.xml");
		factory = ctx.getBean(
				SessionFactory.class,
				"sessionFactory");
		session = factory.openSession();
	}
	@After
	public void destroy(){
		session.close();
		factory.close();
		ctx.close();
	}
	
	@Test
	public void testGet(){
		User user=(User) session.get(
			User.class, 1);
		System.out.println(user); 
	}
}




