package cn.yicha.adchannel.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import cn.yicha.adchannel.model.Document;
import cn.yicha.adchannel.model.Item;
import cn.yicha.adchannel.model.Module;
import cn.yicha.adchannel.model.Picture;
import cn.yicha.adchannel.model.Program;

/**
 * 
 * @author lixiaowen
 *
 */
public class OperateDao {
	
	private static final OperateDao instance = null;
	
	public static OperateDao getInstance() {
		if (instance == null) {
			return new OperateDao();
		}
		return instance;
	}
	/**
	 * 根据id查询不同的表
	 * id=>1:module,2:program,3:item,4:document,5:picture
	 * @param id
	 * @return
	 */
	public List select(Integer id){
		List list = null;
		switch(id){
		case 1:
			list = Module.dao.find("select * from module");
			break;
		case 2:
			list = Program.dao.find("select * from program");
			break;
		case 3:
			list = Item.dao.find("select * from item");
			break;
		case 4:
			list = Document.dao.find("select * from document");
			break;
		case 5:
			list= Picture.dao.find("select * from picture");
			break;
		}
		return list;
	}
	/**
	 * 根据content中的关键字查询文档记录
	 * @param key
	 * @return
	 */
	public List selectDoc(String key){
		return Document.dao.find("select * from document where content like '%"+key+"%'");
	}
}
