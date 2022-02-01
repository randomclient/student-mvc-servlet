package studentmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmvc.dao.StudentDao;
import studentmvc.dto.StudentRequestDto;
import studentmvc.dto.StudentResponseDto;




@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentNo(request.getParameter("id"));
		dto.setStudentName(request.getParameter("name"));
		dto.setStudentClass(request.getParameter("className"));

		StudentDao dao = new StudentDao();
		List<StudentResponseDto> list = dao.select(dto);
		if (list.size() == 0)
			request.setAttribute("msg", "Student not found!");
		else
			request.setAttribute("stulist", list);
		request.getRequestDispatcher("BUD001.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
