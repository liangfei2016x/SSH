package com.liang.dao;

import java.util.List;

import com.liang.entity.Department;



public interface DepartmentDao {

	public int findCount();

	public List<Department> findByPage(int begin, int pageSize);

	public void saveDepartment(Department department);

	public Department findById(Integer did);

	public  void updateDepartment(Department department);

	public void deleteDepartment(Department department);

	public List<Department> findAll();

}
