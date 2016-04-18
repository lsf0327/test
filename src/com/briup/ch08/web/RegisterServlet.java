package com.briup.ch08.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.ch08.bean.Customer;
import com.briup.ch08.service.ICustomerService;
import com.briup.ch08.service.impl.CustomerServiceImpl;

import cn.itcast.commons.CommonUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 关联service对象
	private ICustomerService customerService;

	public RegisterServlet() {
		super();
		customerService = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 处理编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 2. 获取参数
		/*String name = request.getParameter("name");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));*/
		Customer form = CommonUtils.toBean(request.getParameterMap(),Customer.class);
		// 保存校验信息
		Map<String, String> map = new HashMap<String, String>();
		// 把表单的数据封装到Customer
		
		/*
		 * 检验用户名 >用户名不能为空 >用户名的长度必须是3~15
		 */
		if (form.getName() == null || form.getName().trim().isEmpty()) {
			map.put("name", "用户名不能为空！");
		} else if (form.getName().length() < 3 || form.getName().length() > 15) {
			map.put("name", "用户名长度必须为3~15");
		}
		/*
		 * 检验密码 >密码不能为空 >密码的长度必须是3~15
		 */
		if (form.getPassword() == null || form.getPassword().trim().isEmpty()) {
			map.put("password", "密码不能为空！");
		} else if (form.getPassword().length() < 3 || form.getPassword().length() > 15) {
			map.put("password", "密码长度必须为3~15");
		}
		
		if (map == null || map.size() > 0) {
			System.out.println(map.size());

			request.setAttribute("errors", map);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		// 3. 调用service层代码完成注册
		
		customerService.register(form);
		

		// 4. 页面跳转
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		
	}

}
