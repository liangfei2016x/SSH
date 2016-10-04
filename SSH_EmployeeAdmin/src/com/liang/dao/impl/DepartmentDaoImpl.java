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
		//�������Object���� ת��Long
		 Query query=session.createQuery(hql);
		 List<Long> list=query.list();
		if(list.size()>0){
			//Longת��int
			return list.get(0).intValue();
		}
		return 0;
	}
	//��ҳ��ѯ
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
	//��ѯ����
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Department department=(Department) session.get(Department.class, did);
		return department;
	}
	//����
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.update(department);
		
	}
	//ɾ��
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
