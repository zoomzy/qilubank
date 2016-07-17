package cn.yicha.adchannel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yicha.adchannel.dao.OperateDao;
import cn.yicha.adchannel.model.Document;
import cn.yicha.adchannel.model.Module;
import cn.yicha.adchannel.model.Program;
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
	 * 查询模块和他的下级项目
	 * @return
	 */
	public List selectMenu(){
		List<Map> list = new ArrayList<Map>();
		Map map = null;
		List<Program> temp = null;
		//查询模块表
		List<Module> listModule= operateDao.selectModule();
		for(Module m : listModule){
			map = new HashMap();
			map.put("moduleId", m.get("id"));
			map.put("moduleName", m.get("name"));
			//根据模块id查询项目表信息
			temp = operateDao.selectProgramById(Integer.parseInt(m.get("id").toString()));
			map.put("programs", temp);
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List selectItemByProgramId(Integer id){
		return operateDao.selectItemByProgramId(id);
	}
	/**
	 * 根据条目id查询文档信息
	 * @param id
	 * @return
	 */
	public List selectDocByItemId(Integer id){
		return operateDao.selectDocByItemId(id);
	}
	/**
	 * 根据条目id查询图片信息
	 * @param id
	 * @return
	 */
	public List selectPicByItemId(Integer id){
		return operateDao.selectPicByItemId(id);
	}
	/**
	 * 依据关键字查询文档
	 * @param key
	 * @return
	 */
	public List selectDoc(String key){
		return operateDao.selectDoc(key);
	}
	/**
	 * 
	 * @param id
	 * @param content
	 * @return
	 */
	public Boolean saveDoc(Document doc){
		return operateDao.saveDoc(doc);
	}
	/**
	 * 根据文档id删除文档内容记录
	 * @param docId 
	 * @return
	 */
	public boolean deleteDoc(String docId){
		return operateDao.deleteDoc(docId);
	}
	/**
	 * 根据图片id删除图片记录
	 * @param picId
	 * @return
	 */
	public boolean deletePic(String picId){
		return operateDao.deletePic(picId);
	} 
}
