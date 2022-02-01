package studentmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentmvc.dto.StudentRequestDto;
import studentmvc.dto.StudentResponseDto;
import studentmvc.jdbc.MyConnection;


public class StudentDao {
	public static Connection con = null;

	static {
		con = MyConnection.getConnection();
	}

	public void registerStudent(StudentRequestDto dto) {
		String sql = "insert into student (student_id,student_name,class_name,register_date,status)"
				+ " values(?,?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getStudentNo());
			stmt.setString(2, dto.getStudentName());
			stmt.setString(3, dto.getStudentClass());
			stmt.setString(4, dto.getRegisterDate());
			stmt.setString(5, dto.getStatus());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL error : " + e.getMessage());
		}

	}

	public ArrayList<StudentResponseDto> getAllStudent() {
		ArrayList<StudentResponseDto> list = new ArrayList<>();
		String sql = "select * from student";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				StudentResponseDto rdto = new StudentResponseDto();
				rdto.setStudentNo(rs.getString("student_id"));
				rdto.setStudentName(rs.getString("student_name"));
				rdto.setStudentClass(rs.getString("class_name"));
				rdto.setRegisterDate(rs.getString("register_date"));
				rdto.setStatus(rs.getString("status"));
				list.add(rdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateStudent(StudentRequestDto dto) {
		String sql = "update student set student_name=?,class_name=?,register_date=?,status=? where student_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getStudentName());
			stmt.setString(2, dto.getStudentClass());
			stmt.setString(3, dto.getRegisterDate());
			stmt.setString(4, dto.getStatus());
			stmt.setString(5, dto.getStudentNo());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteStudent(StudentRequestDto dto) {
		String sql = "delete from student where student_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getStudentNo());
			stmt.executeUpdate();

			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<StudentResponseDto> select(StudentRequestDto dto) {
		List<StudentResponseDto> list = new ArrayList<StudentResponseDto>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from student");
			if (!dto.getStudentNo().equals("")) {
				ps = con.prepareStatement("select * from student where student_id=?");
				ps.setString(1, dto.getStudentNo());
			} else if (!dto.getStudentName().equals("") || !dto.getStudentClass().equals("")) {
				ps = con.prepareStatement("select * from student where student_name=? or class_name=?");
				ps.setString(1, dto.getStudentName());
				ps.setString(2, dto.getStudentClass());
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentResponseDto res = new StudentResponseDto();
				res.setStudentNo(rs.getString("student_id"));
				res.setStudentName(rs.getString("student_name"));
				res.setStudentClass(rs.getString("class_name"));
				res.setRegisterDate(rs.getString("register_date"));
				res.setStatus(rs.getString("status"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
