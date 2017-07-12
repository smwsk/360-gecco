package cn.succy.geccospider.bean;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Category implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Text
	@HtmlField(cssPath ="body")
	private String body;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
