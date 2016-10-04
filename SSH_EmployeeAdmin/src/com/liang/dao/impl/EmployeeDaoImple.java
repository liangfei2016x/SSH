package com.liang.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import com.liang.dao.EmployeeDao;
import com.liang.entity.Employee;

public class EmployeeDaoImple implements EmployeeDao {
	//ע��sessionFactory
	private SessionFactory sessionFactory;

	//��ȡsessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * ��¼:ȥ���ݿ��ѯ�ľ��巽��
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql="from Employee where username=? and password=?";
		// TODO Auto-generated method stub
		//��ȡsession
		Session session=this.getSessionFactory().getCurrentSession();
		
		Query query=session.createQuery(hql);
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());

		List<Employee> list=query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public int findCount() {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="select count(*) from Employee";
		Query query=session.createQuery(hql);
		List<Long> list=query.list();
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from Employee";
		Query query=session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		//ǰ��������൱������list����� ֻ�������
		List<Employee> list=query.list();
		return list;
	}
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		session.save(employee);
	}
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		Employee employee=(Employee) session.get(Employee.class, eid);
		return employee;
	}
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		session.update(employee);	
	}
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().getCurrentSession();
		session.delete(employee);
		
	}
}
