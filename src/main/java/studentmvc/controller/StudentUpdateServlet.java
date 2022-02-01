package studentmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmvc.dao.StudentDao;
import studentmvc.dto.StudentRequestDto;
import studentmvc.model.StudentBean;



@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		String studentName = request.getParameter("studentName");
		String registerDate = request.getParameter("registerDate");
		String className = request.getParameter("className");
		String status = request.getParameter("status");

		StudentBean bean = new StudentBean();
		bean.setStudentNo(studentNo);
		bean.setStudentName(studentName);
		bean.setStudentClass(className);
		bean.setRegisterDate(registerDate);
		bean.setStatus(status);

		boolean isId = studentNo.equals("");
		boolean isSName = studentName.equals("");
		boolean isReDate = registerDate.equals("");
		boolean isClassName = className.equals("");
		boolean isStatus = status.equals("");

		if (isId && isSName && isReDate && isClassName && isStatus) {
			request.setAttribute("error", "All the fields must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (isId) {
			request.setAttribute("error", "Student id must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (isSName) {
			request.setAttribute("error", "Student name must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (isClassName) {
			request.setAttribute("error", "Class name must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (isReDate) {
			request.setAttribute("error", "Registered date must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (isStatus) {
			request.setAttribute("error", "Status must be filled.");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
		if (!isId && !isSName && !isReDate && !isClassName && !isStatus) {
			StudentRequestDto dto = new StudentRequestDto();
			dto.setStudentNo(bean.getStudentNo());
			dto.setStudentName(bean.getStudentName());
			dto.setStudentClass(bean.getStudentClass());
			dto.setRegisterDate(bean.getRegisterDate());
			dto.setStatus(bean.getStatus());

			StudentDao dao = new StudentDao();
			dao.updateStudent(dto);

			request.setAttribute("msg", "updated successfully");
			request.getRequestDispatcher("/BUD002-01.jsp").forward(request, response);
		}
	}

}
