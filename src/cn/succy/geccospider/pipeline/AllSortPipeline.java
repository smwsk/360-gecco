package cn.succy.geccospider.pipeline;

import java.io.File;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.succy.geccospider.bean.AllSort;
import cn.succy.geccospider.bean.Category;
import cn.succy.geccospider.engine.MainSplider;
import cn.succy.geccospider.tools.FileOperate;
@PipelineName(value="allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort>{
	public static FileOperate fileOperate = new FileOperate();
	@Override
	public void process(AllSort allSort) {
		Category category = allSort.getAjaxContent();
		parserData(category.getBody());
		MainSplider.count++;
	}
	public void parserData(String content){
		File file =null;
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(content);
		//System.out.println(object.get("status"));
		//System.out.println(object.get("data"));
		JsonObject params = (JsonObject) object.get("data");
		//System.out.println(params.get("params"));
		//System.out.println(params.get("list"));
		JsonObject cateArray = (JsonObject) params.get("params");
		String title1 = cateArray.get("cate1").toString();
		String title2 = cateArray.get("cate2").toString();
		title1=title1.substring(1, title1.length()-1);
		title2=title2.substring(1, title2.length()-1);
		if(title2.equals("")){
			file = fileOperate.createFile(title1);
		}else{
			file = fileOperate.createFile(title1+"-"+title2);
		}
		System.out.println(title1+":"+title2);
		JsonArray jsonElement = (JsonArray) params.get("list");
		for (JsonElement jsonElement2 : jsonElement) {
			String result=((JsonObject)jsonElement2).get("title").toString();
			result=result.substring(1, result.length()-1);
			System.out.println(result);
			fileOperate.writeContent(file,result);
		}
	}
}
