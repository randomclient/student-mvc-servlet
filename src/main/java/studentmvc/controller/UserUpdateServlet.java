package studentmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import studentmvc.dao.UserDao;
import studentmvc.dto.UserRequestDto;
import studentmvc.model.UserBean;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm");
		System.out.println(confirmPassword);
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPassword(password);

		boolean isId = id.equals("");
		boolean isName = name.equals("");
		boolean isPassword = password.equals("");
		boolean isConPassword = confirmPassword.equals("");

		if (isId && isName && isPassword && isConPassword) {
			request.setAttribute("error", "All the fields must be filled.");
			request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
		}
		if (isId) {
			request.setAttribute("error", "User Id must be filled.");
			request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
		}
		if (isName) {
			request.setAttribute("error", "User name must be filled.");
			request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
		}
		if (isPassword) {
			request.setAttribute("error", "Password must be filled.");
			request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
		}
		if (isConPassword) {
			request.setAttribute("error", "confirm password must be filled.");
			request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
		}
		if (!isId && !isName && !isPassword) {
			// compare password and confirm password
			if (!password.equals(confirmPassword)) {
				request.setAttribute("error", "password must be the same.");
				request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
			} else {
				// code here
				UserRequestDto dto = new UserRequestDto();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());

				UserDao dao = new UserDao();
				dao.updateUser(dto);
				
				request.setAttribute("msg", "updated successfully");
				request.getRequestDispatcher("/USR002-01.jsp").forward(request, response);
			}
		}

	}

}
