package cn.succy.geccospider.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperate {

	public static File createFile(String fileName) {
		File file = null;
		String filePath = "";
		File directory = new File("");
		String localPath;
		try {
			localPath = directory.getCanonicalPath();
			String root =System.getProperty("user.dir");
			//localPath="c:";
			filePath = localPath + "\\result\\" + fileName + ".txt";
			System.out.println(filePath);
			file = new File(filePath);
			File parentFile = file.getParentFile();
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public static void writeContent(File file,String Content) {
		FileWriter fw =null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(Content);
			pw.flush();
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
