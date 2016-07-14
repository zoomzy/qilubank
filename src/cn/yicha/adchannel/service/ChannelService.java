package cn.yicha.adchannel.service;

import java.util.List;

import cn.yicha.adchannel.dao.ChannelDao;
import cn.yicha.adchannel.model.Channel;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class ChannelService {

	private ChannelDao channelDao = ChannelDao.getInstance();
	
	private static ChannelService instance = null;

	private ChannelService() {

	}

	public static ChannelService getInstance() {
		if (instance == null) {
			return new ChannelService();
		}
		return instance;
	}

	/**
	 * 所有channel
	 * @return
	 */
	public List<Channel> getAllChannels(){
		return channelDao.getAllChannel();
	}
	
	/**
	 * 删除channel
	 * @param id
	 * @return
	 */
	public boolean deleteChannel(int id){
		try{
			channelDao.deleteChannel(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * 添加channel
	 * @param channelName
	 * @param channelId
	 */
	public void addChannel(String channelName, String channelId){
		Channel channel = new Channel();
		channel.set("channel_name", channelName);
		channelDao.addChannel(channel);
	}
}
