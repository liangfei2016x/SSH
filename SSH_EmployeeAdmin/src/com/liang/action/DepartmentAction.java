package com.liang.action;

import com.liang.entity.Department;
import com.liang.entity.PageBean;
import com.liang.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//����Action
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	
	private Department department=new Department();
	//ע�벿�Ź���Service
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	//����ҳ����ʼֵ
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public String findAll(){
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//��pageBean���뵽ֵջ�� 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//����
	public String save(){
		departmentService.saveDepartment(department);
		return "saveSuccess";
	}
	//�༭
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//�޸� 
	public String update(){
		departmentService.updateDepartment(department);
		return "updateSuccess";
	}
	//ɾ��
	public String delete(){
		//�Ȳ�ѯ
		department=departmentService.findById(department.getDid());
		//��ɾ��
		departmentService.deletDepartment(department);
		return "deleteSuccess";
	}
}
