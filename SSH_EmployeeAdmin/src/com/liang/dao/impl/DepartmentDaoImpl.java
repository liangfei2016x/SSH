package com.liang.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import com.liang.dao.DepartmentDao;
import com.liang.entity.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Department";
		Session session=this.sessionFactory.getCurrentSession();
		//查出来是Object类型 转成Long
		 Query query=session.createQuery(hql);
		 List<Long> list=query.list();
		if(list.size()>0){
			//Long转成int
			return list.get(0).intValue();
		}
		return 0;
	}
	//分页查询
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql="from Department";
		Query query=session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list=query.list();
		return list;
	}

	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.save(department);
	}
	//查询单个
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Department department=(Department) session.get(Department.class, did);
		return department;
	}
	//更新
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.update(department);
		
	}
	//删除
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(department);
	}

	public List<Department> findAll() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql="from Department";
		Query query=session.createQuery(hql);
		List<Department> list=query.list();
		return list;
	}
}
