package cn.yicha.adchannel.service;

import cn.yicha.adchannel.dao.UserDao;

/** 
 * @TODO
 * @author zhangcc
 * @date   2016年7月15日 
 */
public class LoginService {

	private UserDao userDao = UserDao.getInstance();
	
	private static LoginService instance = null;
	
	private LoginService(){}
	
	/**
	 * 实现单例模式
	 * @return
	 */
	public static LoginService getInstance(){
		if(instance == null){
			return new LoginService();
		}
		return instance;
	}
	
	/**
	 * 判断是否为合法用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginValidate(String userName, String password){
		return userDao.loginValidate(userName, password);
	}
}
