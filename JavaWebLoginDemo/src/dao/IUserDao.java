package dao;

import domain.User;

public interface IUserDao {
	
	User find(String username,String password);
	
	User find(String username);
	
	/**
	 * @param user
	   *   向数据库内增加用户
	 */
	void add(User user);
	
	/**
	 * @param user
	   *   从数据库内删除用户
	 */
	void delete(User user);
}
