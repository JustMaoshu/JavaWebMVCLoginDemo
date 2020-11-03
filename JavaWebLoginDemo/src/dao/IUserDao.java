package dao;

import domain.User;

public interface IUserDao {
	
	User find(String username,String password);
	
	User find(String username);
	
	/**
	 * @param user
	   *   �����ݿ��������û�
	 */
	void add(User user);
	
	/**
	 * @param user
	   *   �����ݿ���ɾ���û�
	 */
	void delete(User user);
}
