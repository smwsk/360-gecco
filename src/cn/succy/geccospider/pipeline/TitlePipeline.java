package cn.succy.geccospider.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.succy.geccospider.bean.Title;
import cn.succy.geccospider.bean.TitleContent;
import cn.succy.geccospider.engine.MainSplider;
@PipelineName(value="titlePipeline")
public class TitlePipeline implements Pipeline<Title>{
	public static List<HttpRequest> Requests = new ArrayList<>();
	@Override
	public void process(Title titil) {
		TitleContent content = titil.getContent();
		String[] split = content.getContent().toString().split(" ");
		String data = split[0];
		System.out.println(data);
		parserData(data,titil.getRequest());
	}
	public void parserData(String content,HttpRequest request){
		JsonParser parser = new JsonParser();
		JsonArray array = (JsonArray) parser.parse(content);
		for (JsonElement jsonElement : array) {
			String title1=((JsonObject)jsonElement).get("cate1").toString();
			title1=title1.substring(1, title1.length()-1);
			JsonArray jsonElement2 = (JsonArray) ((JsonObject)jsonElement).get("list");
			if("[]".equals(jsonElement2.toString())){
				getUrl(title1, null,request);
			}
			for (JsonElement jsonElement3 : jsonElement2) {
				String title2=jsonElement3.toString();
				title2=title2.substring(1, title2.length()-1);
				getUrl(title1, title2,request);
			}
		}
	}
	private String createUrl(String title1, String title2,String page,String size) {
		String url="";
		if(title2==null){
			url="http://trends.so.com/top/list?cate1="+title1+"&page="+page+"&size="+size;
		}else{
			url="http://trends.so.com/top/list?cate1="+title1+"&cate2="+title2+"&page="+page+"&size="+size;
		}
		return url;
	}
	public void getUrl(String title1, String title2,HttpRequest request){
		Integer page = Integer.parseInt(MainSplider.page.getText());
		Integer size = Integer.parseInt(MainSplider.size.getText());
		for (int i = 1; i <= page; i++) {
			String url = createUrl(title1,title2,i+"",size+"");
			System.out.println(url);
			Requests.add(request.subRequest(url));
		}
	}
}
