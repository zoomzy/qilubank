package cn.yicha.adchannel.service;

import java.util.List;

import cn.yicha.adchannel.dao.ProductDao;
import cn.yicha.adchannel.model.Product;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class ProductService {
	
	private ProductDao productDao = ProductDao.getInstance();

	private static ProductService instance = null;

	private ProductService() {

	}

	public static ProductService getInstance() {
		if (instance == null) {
			return new ProductService();
		}
		return instance;
	}
	
	/**
	 * 获取所有产品
	 * @return
	 */
	public List<Product> getAllProducts(){
		return productDao.getAllModels();
	}
}
