package cn.yicha.adchannel.dao.iface;

import java.util.List;

/** 
 * @TODO
 * @author yicha
 * @date   2015年10月21日 
 */
public interface BaseDao<T> {

	T getModel(int id);
	
	List<T> getAllModels();
	
	void addModel(T t);
	
	void deleteModel(int id);
	
	void updateModel(T t);
}
