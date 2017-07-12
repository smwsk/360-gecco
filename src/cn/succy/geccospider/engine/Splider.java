package cn.succy.geccospider.engine;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;

import cn.succy.geccospider.pipeline.TitlePipeline;
import cn.succy.geccospider.tools.FileOperate;
public class Splider {
	public static FileOperate fileOperate = new FileOperate();
	public static void StartSplider() {
		String classPath="cn.succy.geccospider";
		String url = "http://trends.so.com/result/rank";
		HttpRequest request = new HttpGetRequest(url);
		request.setCharset("gb2312");
		// 本引擎是负责抓取每一个细目对应的页面的第一页的所有商品列表的数据，开启5个线程同时抓取，提升效率
		GeccoEngine.create(classPath).start(request).interval(2000).run();
		
		// 本引擎是负责抓取每一个细目对应的页面的第一页的所有商品列表的数据，开启5个线程同时抓取，提升效率
		GeccoEngine.create().classpath(classPath).start(TitlePipeline.Requests).thread(1)
						.interval(2000).run();
	}
}
