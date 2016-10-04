package com.liang.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.liang.dao.DepartmentDao;
import com.liang.entity.Department;
import com.liang.entity.PageBean;
import com.liang.service.DepartmentService;
import com.sun.org.apache.regexp.internal.recompile;
//department业务实现
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	//分页查询的部分方法
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的条数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总的页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;//前面显示了多少条 接着开始
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//添加部门
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.saveDepartment(department);
		
	}
	//查询单个
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	//更新
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.updateDepartment(department);
	}
	//删除
	public void deletDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartment(department);
	}
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
	

}
