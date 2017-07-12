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
		// �������Ǹ���ץȡÿһ��ϸĿ��Ӧ��ҳ��ĵ�һҳ��������Ʒ�б�����ݣ�����5���߳�ͬʱץȡ������Ч��
		GeccoEngine.create(classPath).start(request).interval(2000).run();
		
		// �������Ǹ���ץȡÿһ��ϸĿ��Ӧ��ҳ��ĵ�һҳ��������Ʒ�б�����ݣ�����5���߳�ͬʱץȡ������Ч��
		GeccoEngine.create().classpath(classPath).start(TitlePipeline.Requests).thread(1)
						.interval(2000).run();
	}
}
