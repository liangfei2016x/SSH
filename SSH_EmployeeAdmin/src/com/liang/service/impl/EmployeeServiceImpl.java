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
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示条数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总条数
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装显示的数据类型
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		//封装总页数
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
	//更新
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);		
	}
	//删除
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
