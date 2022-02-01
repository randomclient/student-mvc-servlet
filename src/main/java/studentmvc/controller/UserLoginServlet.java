package studentmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentmvc.dao.ClassDao;
import studentmvc.dao.UserDao;
import studentmvc.dto.ClassResponseDto;
import studentmvc.dto.UserRequestDto;
import studentmvc.dto.UserResponseDto;
import studentmvc.model.UserBean;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setPassword(password);
		
		UserRequestDto dto = new UserRequestDto();
		dto.setId(bean.getId());
		dto.setPassword(bean.getPassword());

		UserDao dao = new UserDao();
		ClassDao cdao = new ClassDao();
		boolean isAuth = dao.isAuth(dto);

		if (bean.getId().equals("") && bean.getPassword().equals("")) {
			request.setAttribute("error", "User id and password must be filled.");
			request.getRequestDispatcher("/LGN001.jsp").forward(request, response);
		} else if (bean.getPassword().equals("")) {
			request.setAttribute("error", "Password must be filled.");
			request.getRequestDispatcher("/LGN001.jsp").forward(request, response);
		} else if (bean.getId().equals("")) {
			request.setAttribute("error", "User id must be filled.");
			request.getRequestDispatcher("/LGN001.jsp").forward(request, response);
		} else {
			if (isAuth) {
				session.setAttribute("auth", dao.getCurrentUser(dto));

				List<UserResponseDto> userList =  dao.select(dto);
				List<ClassResponseDto> classes = cdao.selectAll();
				
				if(classes!=null || classes==null) {
				session.setAttribute("classlist", classes);
				session.setAttribute("users", userList);
				}
				request.getRequestDispatcher("/M00001.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Record was not found in the database!");
				request.getRequestDispatcher("/LGN001.jsp").forward(request, response);
			}
		}
	}

}
