package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import exception.UserExistException;
import service.IUserService;
import serviceImpl.UserServiceImpl;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordagain");
		
		response.setContentType("text/html;charset=utf-8");
		
		if(!password.equals(passwordAgain)) {
			response.getWriter().print("<script language='javascript'>alert('�������벻һ�£�����������');window.location.href='"+request.getContextPath()+"/servlet/RegisterUIServlet';</script>");
			return;
		}
		IUserService service = new UserServiceImpl();
		User user = new User(username,password,1);
		try {
			service.register(user);
		} catch (UserExistException e) {
			// TODO: handle exception
			response.getWriter().print("<script language='javascript'>alert('��ע����û����Ѵ��ڣ�������ע��');window.location.href='"+request.getContextPath()+"/servlet/RegisterUIServlet';</script>");
			return;
		}
		response.getWriter().print("<script language='javascript'>alert('ע��ɹ�!���¼');window.location.href='"+request.getContextPath()+"/servlet/LoginUIServlet';</script>");
	}

}
