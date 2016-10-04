package com.liang.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.liang.dao.EmployeeDao;
import com.liang.entity.Employee;
import com.liang.entity.PageBean;
import com.liang.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee login(Employee employee) {
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	public PageBean<Employee> findByBean(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean=new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ����
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ������
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ʾ����������
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		//��װ��ҳ��
		double tc=totalCount;
		Double totalPage=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		return pageBean;
	}

	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}
	//����
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);		
	}
	//ɾ��
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
