package com.loginAndRegister.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginAndRegister.dao.UserDao;
import com.loginAndRegister.pojo.User;
import com.userInformation.dao.UserinformationDao;
import com.userInformation.pojo.Userinformation;

public class RegisterServlet extends HttpServlet {

	UserDao dao = null;
	UserinformationDao uinfo = new UserinformationDao();

	public RegisterServlet() {
		super();
		dao = new UserDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> l = new ArrayList<User>();
		String UserName = request.getParameter("userName");
		String UserPasswd = request.getParameter("password");

		String[] checked = request.getParameterValues("checked");
		String value = null;
		if (checked != null) {
			for (String string : checked) {
				value = string;
			}
		}
		l = dao.selectUserName(new User(UserName));

		if (l.isEmpty() == true) {
			if (value != null) {

				User u = new User(UserName, UserPasswd);
				dao.addUser(u);

				l = dao.select(u);
				User user = l.get(0);
				int id = user.getUserId();

				uinfo.add(new Userinformation(id, null, null, null));

				request.getSession().setAttribute("userId", id);
				request.getSession().setAttribute("loginUserName",
						user.getUserName());
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/BokeProject/mainPage.jsp");

			} else {
				String message = "请同意协议";
				request.getSession().setAttribute("message", message);
				response.sendRedirect("/BokeProject/registor.jsp");
			}
		} else {
			String repeat = "用户名已存在";
			request.getSession().setAttribute("repeat", repeat);
			response.sendRedirect("/BokeProject/registor.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
