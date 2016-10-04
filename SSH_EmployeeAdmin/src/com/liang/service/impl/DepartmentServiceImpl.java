package com.liang.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.liang.dao.DepartmentDao;
import com.liang.entity.Department;
import com.liang.entity.PageBean;
import com.liang.service.DepartmentService;
import com.sun.org.apache.regexp.internal.recompile;
//departmentҵ��ʵ��
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	//��ҳ��ѯ�Ĳ��ַ���
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean=new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ������
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ�ܵ�ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin=(currPage-1)*pageSize;//ǰ����ʾ�˶����� ���ſ�ʼ
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//��Ӳ���
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.saveDepartment(department);
		
	}
	//��ѯ����
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	//����
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.updateDepartment(department);
	}
	//ɾ��
	public void deletDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartment(department);
	}
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
	

}
