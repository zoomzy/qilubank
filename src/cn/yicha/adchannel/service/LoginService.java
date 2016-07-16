package cn.yicha.adchannel.service;

import cn.yicha.adchannel.dao.UserDao;
import cn.yicha.adchannel.model.User;
import cn.yicha.adchannel.util.Md5Util;

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
	public User loginValidate(String userName, String password){
		String madPass = Md5Util.md5(password);
		return userDao.loginValidate(userName, madPass);
	}
}
