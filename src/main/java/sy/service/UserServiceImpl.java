package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;


@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAll2() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAll3() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	public List<User> getByType(String type) {
		// TODO Auto-generated method stub
		return userMapper.selectByType(type);
	}

	public User login(User record) {
		// TODO Auto-generated method stub
		return userMapper.login(record);
	}

	
}
