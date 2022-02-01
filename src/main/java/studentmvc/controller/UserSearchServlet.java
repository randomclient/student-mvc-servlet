package studentmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmvc.dao.UserDao;
import studentmvc.dto.UserRequestDto;
import studentmvc.dto.UserResponseDto;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRequestDto dto = new UserRequestDto();
		dto.setId(request.getParameter("id"));
		dto.setName(request.getParameter("name"));
		UserDao dao = new UserDao();
		List<UserResponseDto> list = dao.select(dto);
		if (list.size() == 0)
			request.setAttribute("error", "User not found!");
		else
			request.setAttribute("userlist", list);
		request.getRequestDispatcher("USR001.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
