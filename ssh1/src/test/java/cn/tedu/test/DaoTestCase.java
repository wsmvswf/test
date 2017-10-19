package cn.tedu.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class DaoTestCase {
	ClassPathXmlApplicationContext ctx;
	UserDao dao;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
				"spring-pool.xml",
				"spring-hibernate.xml");
		dao = ctx.getBean("userDao",
				UserDao.class);
	}
	@After
	public void destory(){
		ctx.close();
	}
	@Test
	public void testFindAll(){
		List<User> list = dao.findAll();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	
}





