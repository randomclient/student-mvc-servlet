package studentmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentmvc.dto.UserRequestDto;
import studentmvc.dto.UserResponseDto;
import studentmvc.jdbc.MyConnection;

public class UserDao {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	// check authenticated user or not
	public boolean isAuth(UserRequestDto dto) {
		boolean result = false;
		String sql = "select * from user where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(dto.getId()))
					if (rs.getString("password").equals(dto.getPassword()))
						result = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// retrieve current user
	public UserResponseDto getCurrentUser(UserRequestDto urd) {
		String sql = "select * from user where id=?";
		UserResponseDto dto = new UserResponseDto();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, urd.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;

	}

	// insert user into db
	public void insertUser(UserRequestDto dto) {
		String sql = "insert into user (id,name,password) values(?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getPassword());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error code : " + e.getErrorCode());
		}

	}

	
	//update user into db
	public void updateUser(UserRequestDto dto) {
		String sql = "update user set name=?,password=? where id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getPassword());
			stmt.setString(3, dto.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete user from db
	public void deleteUser(UserRequestDto dto) {
		String sql = "delete from user where id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public List<UserResponseDto> select(UserRequestDto dto) {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from user");
			if (!dto.getId().equals("")) {
				ps = con.prepareStatement("select * from user where id=?");
				ps.setString(1, dto.getId());
			} else if (!dto.getName().equals("")) {
				ps = con.prepareStatement("select * from user where name=?");
				ps.setString(1, dto.getName());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserResponseDto res = new UserResponseDto();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				res.setPassword(rs.getString("password"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
