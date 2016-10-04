package com.liang.service;

import java.util.List;

import com.liang.entity.Department;
import com.liang.entity.PageBean;

public interface DepartmentService {

	public PageBean<Department> findByPage(Integer currPage);

	public void saveDepartment(Department department);

	public Department findById(Integer did);

	public void updateDepartment(Department department);

	public void deletDepartment(Department department);

	public List<Department> findAll();

}
