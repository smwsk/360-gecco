package cn.succy.geccospider.bean;

import com.geccocrawler.gecco.annotation.Ajax;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
@Gecco(matchUrl="http://trends.so.com/top/list?cate1={title1}&page={page}&size={size}",pipelines = {"allSort2Pipeline"})//"consolePipeline",
public class AllSort2 implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String title1;
	
	@RequestParameter
	private String page;
	
	@RequestParameter
	private String size;
	
	@Ajax(url="http://trends.so.com/top/list?cate1={title1}&page={page}&size={size}")
	private Category ajaxContent;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public Category getAjaxContent() {
		return ajaxContent;
	}
	public void setAjaxContent(Category ajaxContent) {
		this.ajaxContent = ajaxContent;
	}
	
}
