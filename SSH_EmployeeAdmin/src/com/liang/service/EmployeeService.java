package com.liang.service;

import com.liang.entity.Employee;
import com.liang.entity.PageBean;

public interface EmployeeService {

	public Employee login(Employee employee);

	public PageBean<Employee> findByBean(Integer currPage);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);
	

}
