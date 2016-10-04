Struts2 和 Spring 整合的俩种方式

1.Action的类由Struts2自身去创建
  也就是在Struts.xml去配置Action
  
2.Action的类由Spring框架去创建
 在Spring注入Action类 让Spring去管理 注意：scope="prototype" 默认的为单例
 然后在Struts.xml中直接调用 id 就可以了
 
Hibernate和Spring 整合

问题
Hibernate整合Spring 
错误：nested exception is java.lang.NoClassDefFoundError: org/hibernate/cache/CacheProvider 
因为用的hibernate4 所以把hibernate3换成hibernate4
换成：class="org.springframework.orm.hibernate4.LocalSessionFactoryBean"
错误：java.lang.ClassCastException: org.springframework.orm.hibernate4.SessionHolder cannot be cast to org.springframework.orm.hibernate3.SessionHolder
hibernate4 没提供 HebernateDaoSupport 支持
直接掉 sessionFactory来处理

public class ProductDao{

	private SessionFactory sessionFactory;
	//注入sessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了。。");
		this.getSessionFactory().getCurrentSession().save(product);
	}
}

OpenSessionInViewFilter的主要功能是用来把一个Hibernate Session和一次完整的请求过程对应的线程相绑定。
Open Session In View在request把session绑定到当前thread期间一直保持hibernate session在open状态，
使session在request的整个期间都可以使用，如在View层里PO也可以lazy loading数据，如 ${ company.employees }。
当View 层逻辑完成后，才会通过Filter的doFilter方法或Interceptor的postHandle方法自动关闭session。


id to load is required for loading 记得加 隐藏id
