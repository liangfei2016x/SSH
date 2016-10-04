package com.liang.action;

import com.liang.entity.Department;
import com.liang.entity.PageBean;
import com.liang.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//部门Action
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	
	private Department department=new Department();
	//注入部门管理Service
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	//设置页数初始值
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public String findAll(){
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//将pageBean存入到值栈中 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//增加
	public String save(){
		departmentService.saveDepartment(department);
		return "saveSuccess";
	}
	//编辑
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//修改 
	public String update(){
		departmentService.updateDepartment(department);
		return "updateSuccess";
	}
	//删除
	public String delete(){
		//先查询
		department=departmentService.findById(department.getDid());
		//在删除
		departmentService.deletDepartment(department);
		return "deleteSuccess";
	}
}
