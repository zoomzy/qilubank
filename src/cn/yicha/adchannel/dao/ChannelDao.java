package cn.yicha.adchannel.dao;

import java.util.List;

import cn.yicha.adchannel.model.Channel;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class ChannelDao {

	private static final String TABLE_NAME = "channel";
	
	private static ChannelDao instance = null;

	private ChannelDao() {

	}

	public static ChannelDao getInstance() {
		if (instance == null) {
			return new ChannelDao();
		}
		return instance;
	}
	
	/**
	 * 根据id得到渠道
	 * @param id
	 * @return
	 */
	public Channel getChannelById(int id){
		return Channel.dao.findFirst("select * from " + TABLE_NAME + " where id=?", id);
	}
	
	/**
	 * 获取所有渠道
	 * @return
	 */
	public List<Channel> getAllChannel(){
		return Channel.dao.find("select * from " + TABLE_NAME);
	}
	
	/**
	 * 添加渠道
	 * @param channel
	 */
	public void addChannel(Channel channel){
		if(channel == null){
			return;
		}
		channel.save();
	}
	
	/**
	 * 根据id删除渠道
	 * @param id
	 */
	public void deleteChannel(int id){
		Channel channel = getChannelById(id);
		channel.delete();
	}
}
