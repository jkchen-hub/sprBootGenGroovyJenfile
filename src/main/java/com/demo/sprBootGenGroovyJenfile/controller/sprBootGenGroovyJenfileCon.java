package com.demo.sprBootGenGroovyJenfile.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sprBootGenGroovyJenfile.domain.groovyScript;
import com.demo.sprBootGenGroovyJenfile.writeFile.writeFile;


/**
 * 生成groovy脚本文件，命名为Jenkinsfile.txt，并保存到项目根目录下
 * @author jkchen
 * @2019-7-22
 *
 */
//@RestController
@Controller
public class sprBootGenGroovyJenfileCon {
	
	// 输出日志信息
	private final static Logger logger = LoggerFactory.getLogger(sprBootGenGroovyJenfileCon.class);
	
    @GetMapping("/genGroScr")
    public String genGroScript(groovyScript Jenkinsfile){
        //System.out.println(logger.info(null)); //输出日志信息
    	/**
    	 * 获得输入的github url和maven build信息，并加入到输出的groovy脚本文件中
    	 */

    	String githubUrl = Jenkinsfile.getGithubUrl();
    	String mavenBuild = Jenkinsfile.getMavenBuild();
        System.out.println(Jenkinsfile.toString());
        List<String> jenkinsfileList = new ArrayList<String>();
        jenkinsfileList.add(githubUrl);
        jenkinsfileList.add(mavenBuild);
       
        /**
                      *   实例化文件writeFile类，成功读写后，返回文件路径；否则返回错误信息
        */
        writeFile jenkinsfilewrite = new writeFile();
        String jenkinsfilePath = jenkinsfilewrite.writeJenFile(jenkinsfileList);
        System.out.println(jenkinsfilePath);
        
        return "download";//跳转到groovy脚本下载页面
        
    }
}