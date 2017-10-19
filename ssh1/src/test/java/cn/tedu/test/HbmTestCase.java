package cn.tedu.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.User;

public class HbmTestCase {
	SessionFactory factory;
	Session session;

	@Before
	public void init(){
		Configuration cfg=new Configuration();
		//加载主配置文件
		cfg.configure("hibernate.cfg.xml");
		//创建工厂对象
		factory = cfg.buildSessionFactory();
		//创建Session对象
		session = factory.openSession();
	}
	
	@After
	public void destory(){
		//Session 使用以后务必关闭
		session.close();
		factory.close();
	}
	
	@Test
	public void testSave(){
		Transaction tx = 
				session.beginTransaction();
		User user = new User(
			1, "Tom", 5, "北京");
		session.save(user);
		//user = new User(
		//	2, "Jerry", 5, "上海");
		//session.save(user);
		//user = new User(
		//	3, "李洪鹤", 6, "北京");
		//session.save(user);
		tx.commit();
	}
	
	@Test
	public void testGet(){
		User user = (User)session.get(
			User.class, 1);
		System.out.println(user); 
	}
	
	@Test
	public void testUpdate(){
		Transaction tx=session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		user.setName("范萌萌"); 
		session.update(user);
		tx.commit();
	}
	
	@Test
	public void testDelete(){
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, 1);
		session.delete(user);
		tx.commit();
	}
	
	@Test
	public void testFindAll(){
		//sql: select * from t_user
		//hql:          from User
		String hql="from User";
		Query query=session.createQuery(hql);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testFindByAddress(){
		String addr = "北京";
		//sql:select * from t_user 
		//    where t_address=?
		//hql:         from User
		//    where address=?
		String hql = "from User "
				+ "where address=?"; 
		Query query=session.createQuery(hql);
		//参数绑定
		query.setString(0, addr);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	@Test
	public void testFindByAge(){
		int age=5;
		String hql="from User "
				+ "where age=:age";
		Query query=session.createQuery(hql);
		//按照名称替换参数,替换 :age 为 5
		query.setInteger("age", age);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	
	@Test
	public void testFind(){
		//sql: select t_id, t_name 
		//     from t_user
		//     where t_address=?
		//HQL: select new map(
		//     id as id, name as name) 
		//     from User
		//     where address=?
		String hql="select new map("
				+ "id as id, name as name) "
				+ "from User "
				+ "where address=?";
		Query query = session.createQuery(hql);
		query.setString(0, "北京");
		List<Map<String, Object>> list=
			query.list();
		for (Map<String, Object> map : list) {
			System.out.println(map); 
		}
	}
	
	
	@Test
	public void testState1(){
		Transaction tx = session.beginTransaction();
		//临时状态
		User user = new User(5, "Andy", 7, "上海");
		//持久状态
		session.save(user);
		//持久状态下更新属性将自动更新数据库
		user.setName("Wang");
		tx.commit();
	}
	
	@Test
	public void testState2(){
		Transaction tx=session.beginTransaction();
		//临时状态
		User user = new User(8, "范传奇", 8, "北京");
		//持久状态
		session.save(user);
		user.setAge(20);
		//强制执行缓存在session中的SQL
		session.flush();
		//游离状态
		session.evict(user);
		user.setAge(30);
		session.flush();
		tx.commit();
	}
	
	@Test
	public void testState3(){
		Transaction tx = session.beginTransaction();
		//get返回的对象是持久状态的
		User user=
			(User)session.get(User.class, 8);
		//游离状态
		session.evict(user);
		user.setAddress("昆明");
		//返回持久状态
		session.update(user);
		tx.commit();
	}
}



















