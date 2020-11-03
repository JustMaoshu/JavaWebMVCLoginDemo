package service;

import domain.User;
import exception.UserExistException;

public interface IUserService {

	/**
	 * @param user
	 * @throws UserExistException
	   * �û�ע�ᣬ���ע����û����Ѿ��������׳�UserExistException
	 */
	void register(User user) throws UserExistException;
	
	/**
	 * @param username
	 * @param password
	 * @return User
	   *   �û���¼���ɹ�����User��ʧ�ܷ���null
	 */
	User login(String username,String password);
}
