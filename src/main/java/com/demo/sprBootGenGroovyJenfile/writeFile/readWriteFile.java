package com.demo.sprBootGenGroovyJenfile.writeFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

/**
 * 在当前SpringBoot项目根目录下，写groovy脚本文件，文件名为Jenkinsfile.txt
 * 
 * @author jkchen 
 * @2019-7-23
 */
public class readWriteFile {

	public String writeJenFile(List<String> JenkinsfileList) {
		String basePath = getResourceBasePath();
		// 获取文件路径
		String studentResourcePath = new File(basePath, "Jenkinsfile.txt").getAbsolutePath();
		ensureDirectory(studentResourcePath); // 保证目录一定存在
		changeLine(studentResourcePath, JenkinsfileList);
		return studentResourcePath;  // 返回文件路径
	}

	/**
	 * 读取文件内容并修改特定行
	 * 
	 * @param
	 */
	public void changeLine(String studentResourcePath, List<String> JenkinsfileList) {
		try {
			int changeLineNum_1 = 5;
			int changeLineNum_2 = 13;
			String changeStr_1 = "	git '" + JenkinsfileList.get(0) + "'";
			String changeStr_2 = "		sh '" + "\"$MVN_HOME/bin/mvn\"" + " -Dmaven.test.failure.ignore " + JenkinsfileList.get(1) + "'";
			// 读出文件
			BufferedReader reader = new BufferedReader(new FileReader("D:\\联通系统集成实习\\spring boot groovy\\sprBootGenGroovyJenfile\\Jenkinsfile.txt"));
			// 写入文件
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(studentResourcePath)));
			String str = reader.readLine();
			while (str != null) {
				if (--changeLineNum_1 == 0)
					writer.write(changeStr_1 + "\r\n");
				else if (--changeLineNum_2 == 0) {
					writer.write(changeStr_2 + "\r\n");
				} else {
					writer.write(str + "\r\n");
				}
				str = reader.readLine();
			}
			reader.close();
			writer.flush();
			writer.close();
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取项目根路径
	 * 
	 * @return
	 */
	private static String getResourceBasePath() {
		// 获取根目录
		File path = null;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
		} catch (FileNotFoundException e) {

		}
		if (path == null || !path.exists()) {
			path = new File("");
		}

		String pathStr = path.getAbsolutePath();
		// 在eclipse和target同级目录
		pathStr = pathStr.replace("\\target\\classes", "");

		return pathStr;
	}

	/**
	 * 保证拷贝的文件的目录一定要存在
	 * 
	 * @param filePath 文件路径
	 */
	public static void ensureDirectory(String filePath) {
		if (StringUtils.isBlank(filePath)) {
			return;
		}
		filePath = replaceSeparator(filePath);
		if (filePath.indexOf("/") != -1) {
			filePath = filePath.substring(0, filePath.lastIndexOf("/"));
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
	}

	/**
	 * 将符号“\\”和“\”替换成“/”，有时候便于统一的处理路径的分隔符，避免同一个路径出现两个或三种不同的分隔符
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceSeparator(String str) {
		return str.replace("\\", "/").replace("\\\\", "/");
	}
}
