package com.demo.sprBootGenGroovyJenfile.controller;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sprBootGenGroovyJenfile.domain.groovyScript;
import com.demo.sprBootGenGroovyJenfile.writeFile.readWriteFile;
import com.demo.sprBootGenGroovyJenfile.writeFile.writeGroovyFile;

/**
 * 生成groovy脚本文件，命名为Jenkinsfile.txt，并保存到项目根目录下
 * 
 * @author jkchen 
 * @ 2019-7-22
 */
//@RestController
@Controller
public class sprBootGenGroovyJenfileCon {

	// 输出日志信息
	private final static Logger logger = LoggerFactory.getLogger(sprBootGenGroovyJenfileCon.class);

	/**
	 * 处理 "/groovyScript" 的 GET 请求
	 * @return 返回信息填写首页
	 */
//	@RequestMapping(value="/", method=RequestMethod.GET)//旧版本的写法
	@GetMapping(value = "/groovyScript") // 新版本的写法
	public String genGroScr() {
		return "genGroScr";
	}

	/**
	 * 处理 "/groovyScript" 的post请求
	 * 
	 * @param Jenkinsfile
	 * @return
	 */
	@PostMapping(value = "/getSubmit")
	public void getSubmit(groovyScript Jenkinsfile) {
//		 System.out.println(logger.info(null)); //输出日志信息
		/**
		 * 获得输入的github url和maven build信息，并加入到输出的groovy脚本文件中
		 * 注意：这里的groovyScript类中的变量名（githubUrl，mavenBuild）应该与前端页面中
		 * 的inout标签中的name属性保持一致，否则会写入null值
		 */
		String githubUrl = Jenkinsfile.getGithubUrl();
		String mavenBuild = Jenkinsfile.getMavenBuild();
//		System.out.println(Jenkinsfile.toString());
		List<String> jenkinsfileList = new ArrayList<String>();
		jenkinsfileList.add(githubUrl);
		jenkinsfileList.add(mavenBuild);

		/**
		 * 实例化文件writeFile类，成功读写后，返回文件路径；否则返回错误信息
		 */
//		String jenkinsfilePath = new readWriteFile().writeJenFile(jenkinsfileList);;
		String jenkinsfilePath = new writeGroovyFile().writeJenFile(jenkinsfileList);
		System.out.println(jenkinsfilePath);
//		System.out.println(jenkinsfilePath); //打印文件路径信息
//        return "download";//跳转到groovy脚本下载页面
//        return "welcome";

	}
}