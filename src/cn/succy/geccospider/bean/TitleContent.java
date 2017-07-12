package cn.succy.geccospider.bean;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class TitleContent implements HtmlBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@HtmlField(cssPath ="body")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
