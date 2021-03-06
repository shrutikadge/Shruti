package com.mikadosolutions.training.springmvc.interceptor;

import javax.servlet.http.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter; 
import com.mikadosolutions.training.springmvc.bean.User;

public class SecurityInterceptor extends HandlerInterceptorAdapter
{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception
	{
		System.out.println("Inside Interceptor "+handler);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null)
		{
			response.sendRedirect("/SpringHibernate/login");
			return false;
		}
		else
		{
			return true;
		}
	}
};
