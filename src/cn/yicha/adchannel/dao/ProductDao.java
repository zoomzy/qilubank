package cn.yicha.adchannel.dao;

import java.util.List;

import cn.yicha.adchannel.dao.iface.BaseDao;
import cn.yicha.adchannel.model.Product;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class ProductDao implements BaseDao<Product>{
	
	private static final String TABLE_NAME = "product";

	private static ProductDao instance = null;

	private ProductDao() {

	}

	public static ProductDao getInstance() {
		if (instance == null) {
			return new ProductDao();
		}
		return instance;
	}

	@Override
	public Product getModel(int id) {
		// TODO Auto-generated method stub
		return Product.dao.findById(id);
	}

	@Override
	public List<Product> getAllModels() {
		// TODO Auto-generated method stub
		return Product.dao.find("select * from " + TABLE_NAME);
	}

	@Override
	public void addModel(Product t) {
		// TODO Auto-generated method stub
		if(t != null){
			t.save();
		}
	}

	@Override
	public void deleteModel(int id) {
		// TODO Auto-generated method stub
		Product product = getModel(id);
		product.delete();
	}

	@Override
	public void updateModel(Product t) {
		// TODO Auto-generated method stub
		if(t != null){
			t.update();
		}
	}
	
}
