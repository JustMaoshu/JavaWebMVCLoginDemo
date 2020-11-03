package service;

import domain.User;
import exception.UserExistException;

public interface IUserService {

	/**
	 * @param user
	 * @throws UserExistException
	   * 用户注册，如果注册的用户名已经存在则抛出UserExistException
	 */
	void register(User user) throws UserExistException;
	
	/**
	 * @param username
	 * @param password
	 * @return User
	   *   用户登录，成功返回User，失败返回null
	 */
	User login(String username,String password);
}
