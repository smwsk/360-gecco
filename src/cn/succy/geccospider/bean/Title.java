package cn.succy.geccospider.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
@Gecco(matchUrl="http://trends.so.com/result/rank",pipelines={"consolePipeline","titlePipeline"})
public class Title implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@HtmlField(cssPath="body > script")
	private TitleContent content;
	
	@Request
	private HttpRequest request;
	
	public TitleContent getContent() {
		return content;
	}
	public void setContent(TitleContent content) {
		this.content = content;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	
}
