package cn.yicha.adchannel.bean;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class AdInfoBean {

	private String channelName;
	private String productName;
	private String pageName;
	private String adPositionName;
	private String content;
	private int status;

	public AdInfoBean() {

	}

	public AdInfoBean(String channelName, String productName, String pageName,
			String adPositionName, String content, int status) {
		this.channelName = channelName;
		this.productName = productName;
		this.pageName = pageName;
		this.adPositionName = adPositionName;
		this.content = content;
		this.status = status;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getAdPositionName() {
		return adPositionName;
	}

	public void setAdPositionName(String adPositionName) {
		this.adPositionName = adPositionName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
