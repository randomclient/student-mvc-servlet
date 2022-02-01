package studentmvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import studentmvc.dao.ClassDao;
import studentmvc.dto.ClassRequestDto;
import studentmvc.model.ClassBean;

@WebServlet("/ClassRegisterServlet")
public class ClassRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("classId");
		String name = request.getParameter("className");

		ClassBean bean = new ClassBean();
		bean.setClassId(id);
		bean.setClassName(name);

		ClassRequestDto dto = new ClassRequestDto();
		dto.setClassId(bean.getClassId());
		dto.setClassName(bean.getClassName());

		boolean isIdEm = bean.getClassId().equals("");
		boolean isCnEm = bean.getClassName().equals("");
		if (isIdEm && isCnEm) {
			request.setAttribute("error", "class id and class name must be filled.");
			request.getRequestDispatcher("/BUD003.jsp").forward(request, response);
		} else if (isIdEm) {
			request.setAttribute("error", "class id must be filled.");
			request.getRequestDispatcher("/BUD003.jsp").forward(request, response);
		} else if (isCnEm) {
			request.setAttribute("error", "class name must be filled.");
			request.getRequestDispatcher("/BUD003.jsp").forward(request, response);
		} else {
			ClassDao dao = new ClassDao();
			dao.addClass(dto);

			request.setAttribute("msg", "register successfully.");
			request.getRequestDispatcher("/BUD003.jsp").forward(request, response);
		}
	}

}
