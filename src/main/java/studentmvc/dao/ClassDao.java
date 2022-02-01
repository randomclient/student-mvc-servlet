package studentmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentmvc.dto.ClassRequestDto;
import studentmvc.dto.ClassResponseDto;
import studentmvc.jdbc.MyConnection;

public class ClassDao {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public void addClass(ClassRequestDto dto) {

		String sql = "insert into class(id,name) values(?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getClassId());
			stmt.setString(2, dto.getClassName());
			int result = stmt.executeUpdate();
			if (result == 1)
				System.out.println("insert successfully...");
			else
				System.out.println("fail to insert");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ClassResponseDto> selectAll() {
		List<ClassResponseDto> list = new ArrayList<>();
		String sql = "select name from class";

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ClassResponseDto rdto = new ClassResponseDto();
				rdto.setClassName(rs.getString("name"));
				list.add(rdto);
			}
		} catch (SQLException e) {
			System.out.println("error code is " + e.getErrorCode());
		}

		return list;

	}
}
