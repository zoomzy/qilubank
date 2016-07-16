package cn.yicha.adchannel.service;

import java.util.List;

import cn.yicha.adchannel.dao.OperateDao;
/**
 * 
 * @author lixiaowen
 *
 */
public class OperateService {
	private OperateDao operateDao = OperateDao.getInstance();
	
	private static OperateService instance = null;
	
	/**
	 * 实现单例模式
	 * @return
	 */
	public static OperateService getInstance(){
		if(instance == null){
			return new OperateService();
		}
		return instance;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List select(Integer id){
		return operateDao.select(id);
	}
	/**
	 * 依据关键字查询文档
	 * @param key
	 * @return
	 */
	public List selectDoc(String key){
		return operateDao.selectDoc(key);
	}
}
