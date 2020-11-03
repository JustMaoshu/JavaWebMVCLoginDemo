package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.IUserService;
import serviceImpl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		IUserService service = new UserServiceImpl();
		User user = service.login(username, password);
		if (user != null) {
			// 登录成功
			request.getSession().setAttribute("user", user);
			String message = String.format("恭喜：%s,登录成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
					user.getUsername(), request.getContextPath() + "/index.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else {
			//登录失败
			String message = String.format("用户名或密码错误！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath() + "/index.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

}
