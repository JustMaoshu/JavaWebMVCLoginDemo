package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IUserDao;
import domain.User;
import util.DBHelper;

public class UserDaoImpl implements IUserDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;

	/**
	 * 根据用户名和密码在数据库中查询，存在则返回找到的user，不存在则返回null
	 */
	@Override
	public User find(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		conn = DBHelper.getConnection();
		try {
			String sql = "select * from user where username=? and password=?";
			if(conn==null) {
				System.out.println("connection为null！");
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			res = ps.executeQuery();
			while (res.next()) {
				user = new User(res.getString("username"), res.getString("password"),
						Integer.parseInt(res.getString("role")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(conn, ps, res);
		}
		return user;
	}

	/**
	 * 根据用户名查询数据库
	 */
	@Override
	public User find(String username) {
		// TODO Auto-generated method stub
		User user = null;
		conn = DBHelper.getConnection();
		try {
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			res = ps.executeQuery();
			while (res.next()) {
				user = new User(res.getString("username"), res.getString("password"),
						Integer.parseInt(res.getString("role")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(conn, ps, res);
		}
		return user;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConnection();
		try {
			String sql = "insert into user(username,password,role) values(?,?,1)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(conn, ps);
		}
	}

	@Override
	public void delete(User user) {
		conn = DBHelper.getConnection();
		// TODO Auto-generated method stub
		try {
			String sql = "delete from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(conn, ps);
		}
	}

}
