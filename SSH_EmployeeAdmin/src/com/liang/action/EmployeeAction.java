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
	//ģ��������Ҫ�Ķ���
	private Employee employee=new Employee();
	//ע��ҵ����
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
	//����ҳ����ʼֵ
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//��¼
	public String login(){
		Employee exitEmployee=employeeService.login(employee);
		if(exitEmployee!=null){
			ActionContext.getContext().getSession().put("exitEmployee",exitEmployee.getUsername());
			return "success";
		}else{
			//��¼ʧ��
			this.addActionError("�û��������������");
			return "input";
		}
	}
	public String logout(){
		if(ActionContext.getContext().getSession().get("exitEmployee")!=null){
			ActionContext.getContext().getSession().remove("exitEmployee");
		}
		return "logout";
	}
	//��ҳ
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByBean(currPage);
		//��pageBean���뵽ֵջ�� 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//��ʾ���ҳ��
	public String saveUI(){
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	//����
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	//�༭
	public String edit(){
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	//����
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	//ɾ��
	public String delete(){
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
