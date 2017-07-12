package cn.succy.geccospider.bean;

import com.geccocrawler.gecco.annotation.Ajax;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
@Gecco(matchUrl="http://trends.so.com/top/list?cate1={title1}&cate2={title2}&page={page}&size={size}",pipelines = {"allSortPipeline"})
public class AllSort implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Request
	private HttpRequest request;
	
	@RequestParameter("title1")
	private String title1;
	
	@RequestParameter("title2")
	private String title2;
	
	@RequestParameter("page")
	private String page;
	
	@RequestParameter("size")
	private String size;
	
	@Ajax(url="http://trends.so.com/top/list?cate1={title1}&cate2={title2}&page={page}&size={size}")
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
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
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
