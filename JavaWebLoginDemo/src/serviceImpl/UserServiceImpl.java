package serviceImpl;

import dao.IUserDao;
import daoImpl.UserDaoImpl;
import domain.User;
import exception.UserExistException;
import service.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userdao = new UserDaoImpl();
	
	@Override
	public void register(User user) throws UserExistException {
		// TODO Auto-generated method stub
		if (userdao.find(user.getUsername()) != null) {
			throw new UserExistException("您注册的用户名已经存在");
		}
		userdao.add(user);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.find(username, password);
	}

}
