package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IUserDao;
import daoImpl.UserDaoImpl;
import domain.User;

/**
 * @author Sumail 数据库工作类
 */
public class DBHelper {
	// 数据库驱动
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	// 连接数据库的URL地址
	private static final String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";

	private static final String username = "root";
	private static final String password = "";

	private static Connection connection = null;

	// 静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 单例模式返回数据库连接对象
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeAll(Connection connection, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection connection, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {

//		Connection conn = DBHelper.getConnection();
//		if(conn!=null) {
//			System.out.println("数据库连接正常");
//		}
//		Statement statement = conn.createStatement();
//		String sql = "select * from login"; 
//		ResultSet rs = statement.executeQuery(sql);
//		String username = null;
//		String password = null;
//		while(rs.next()) {
//			username = rs.getString("username");
//			password = rs.getString("password");
//			System.out.println(username+"    "+password);
//		}
//		rs.close();
//		conn.close();

		IUserDao userDao = new UserDaoImpl();
		User user = new User("zhangxu", "zhanglili", 1);
		userDao.add(user);
	}

}
