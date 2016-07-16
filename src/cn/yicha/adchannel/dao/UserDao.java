package cn.yicha.adchannel.dao;

import cn.yicha.adchannel.model.User;
/**
 * 
 * @author zhangcc
 *
 */
public class UserDao {

	private static final String TABLE_NAME = "user"; 

	private static final UserDao instance = null;

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (instance == null) {
			return new UserDao();
		}
		return instance;
	}
	
	/**
	 * 根据用户名，密码查找用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public User loginValidate(String userName, String password){
		return User.dao.findFirst("select * from " + TABLE_NAME + " where name=? and pwd=?", userName, password);
	}
	
}
