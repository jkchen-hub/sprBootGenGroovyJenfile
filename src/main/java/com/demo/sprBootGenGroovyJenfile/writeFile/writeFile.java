package com.demo.sprBootGenGroovyJenfile.writeFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

public class writeFile {

	/**
	   *  在当前SpringBoot项目根目录下，写groovy脚本文件，文件名为Jenkinsfile.txt
	 * @author jkcehn
	 * @2019-7-23
	 */
	public String writeJenFile(List<String> JenkinsfileList) {
	    try {
			String basePath = getResourceBasePath();
	        String studentResourcePath = new File(basePath, "Jenkinsfile.txt").getAbsolutePath();
	        // 保证目录一定存在
	        ensureDirectory(studentResourcePath);
	        //System.out.println("studentResourcePath = " + studentResourcePath);//打印文件路径
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(studentResourcePath)));
	        for (String str : JenkinsfileList) {
	            StringBuffer buffer = new StringBuffer();
	            buffer.append(str);
	            buffer.append("\r\n");
	            writer.write(buffer.toString());
	        } 
	        writer.flush();
	        writer.close();
	        return studentResourcePath;//成功读写时，返回文件Jenkinsfile.txt路径
		}catch(IOException IOE) {
			return IOE.getStackTrace().toString(); //返回异常信息
	    }
	}

    /**
         * 获取项目根路径
     * 
     * @return
     */
    private static String getResourceBasePath() {
        // 获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
        	
        }
        if (path == null || !path.exists()) {
            path = new File("");
        }

        String pathStr = path.getAbsolutePath();
        // 如果是在eclipse中运行，则和target同级目录,如果是jar部署到服务器，则默认和jar包同级
        pathStr = pathStr.replace("\\target\\classes", "");

        return pathStr;
    }
    
    /**
           * 保证拷贝的文件的目录一定要存在
     * 
     * @param filePath
             *            文件路径
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
           * 将符号“\\”和“\”替换成“/”，有时候便于统一的处理路径的分隔符，,避免同一个路径出现两个或三种不同的分隔符
     * 
     * @param str
     * @return
     */
    public static String replaceSeparator(String str) {
        return str.replace("\\", "/").replace("\\\\", "/");
    }
}