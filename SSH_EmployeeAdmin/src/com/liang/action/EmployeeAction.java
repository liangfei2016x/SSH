package com.liang.action;

import java.util.List;


import com.liang.entity.Department;
import com.liang.entity.Employee;
import com.liang.entity.PageBean;
import com.liang.service.DepartmentService;
import com.liang.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	//模型驱动需要的对象
	private Employee employee=new Employee();
	//注入业务类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}



	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//设置页数初始值
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//登录
	public String login(){
		Employee exitEmployee=employeeService.login(employee);
		if(exitEmployee!=null){
			ActionContext.getContext().getSession().put("exitEmployee",exitEmployee.getUsername());
			return "success";
		}else{
			//登录失败
			this.addActionError("用户名或者密码错误");
			return "input";
		}
	}
	public String logout(){
		if(ActionContext.getContext().getSession().get("exitEmployee")!=null){
			ActionContext.getContext().getSession().remove("exitEmployee");
		}
		return "logout";
	}
	//分页
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByBean(currPage);
		//将pageBean存入到值栈中 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//显示添加页面
	public String saveUI(){
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	//保存
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	//编辑
	public String edit(){
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	//更新
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	//删除
	public String delete(){
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
