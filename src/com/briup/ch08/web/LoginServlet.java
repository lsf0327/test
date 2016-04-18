package com.briup.ch08.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.ch08.bean.Customer;
import com.briup.ch08.common.exception.ServiceException;
import com.briup.ch08.service.ICustomerService;
import com.briup.ch08.service.impl.CustomerServiceImpl;
import com.mysql.jdbc.EscapeTokenizer;

import cn.itcast.commons.CommonUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICustomerService customerService;
    public LoginServlet() {
        super();
        customerService = new CustomerServiceImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException     {
		//1. 设置编码
		request.setCharacterEncoding("utf-8");// 请求编码(POST)
		response.setContentType("text/html;charset=utf-8");// 响应编码
		//2. 获取参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//3.调用service完成业务逻辑  并把错误信息保存到request域中 转发
		try {
			customerService.login(name, password);
			Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
			request.getSession().setAttribute("Customer", customer);
			//4.页面跳转
			response.sendRedirect("/ch11/main.jsp");
		}
		catch(ServiceException se){
			request.setAttribute("msg", se.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	
	}

}
