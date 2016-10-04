package com.liang.interceptor;

import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		//���������
		ActionContext actionContext=ActionContext.getContext();
		//��ȡsession
		Map<String, Object> session=actionContext.getSession();
		System.out.println(session.toString()+"--------------");
		if(session.get("exitEmployee")!=null){
			String result=actionInvocation.invoke();
			return result;
		}else{
			return "input";
		}
	}
}
