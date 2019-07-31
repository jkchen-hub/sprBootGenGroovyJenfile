package com.demo.sprBootGenGroovyJenfile.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.sprBootGenGroovyJenfile.domain.groovyScript;
import com.demo.sprBootGenGroovyJenfile.writeFile.writeGroovyFile;

/**
 * 生成groovy脚本文件，命名为Jenkinsfile.txt，并保存到项目根目录下
 * 
 * @author jkchen 
 * @ 2019-7-22
 */

@Controller
public class sprBootGenGroovyJenfileCon {

	//使用指定的类初始化日志对象
	private final static Logger logger = LoggerFactory.getLogger(sprBootGenGroovyJenfileCon.class);

	/**
	 * 处理 "/groovyScript" 的 GET 请求
	 * @return 返回信息填写首页
	 */
	@GetMapping(value = "/groovyScript")
	public String genGroScr() {
		return "genGroScr";
	}

	/**
	 * 处理 "/getSubmit" 的POST请求
	 * 
	 * @param Jenkinsfile
	 * @return
	 */
	@PostMapping(value = "/getSubmit")
	public void getSubmit(groovyScript Jenkinsfile) {
		logger.info("Jenkinsfile=" + Jenkinsfile); //输出日志信息
		String githubUrl = Jenkinsfile.getGithubUrl();  //获得前端输入的github地址信息
		String mavenBuild = Jenkinsfile.getMavenBuild();
		List<String> jenkinsfileList = new ArrayList<String>();
		jenkinsfileList.add(githubUrl);
		jenkinsfileList.add(mavenBuild);

		/**
		 * 实例化文件writeFile类，成功读写后，返回文件路径；否则返回错误信息
		 */
		String jenkinsfilePath = new writeGroovyFile().writeJenFile(jenkinsfileList);
		System.out.println(jenkinsfilePath);
	}
}