package com.demo.sprBootGenGroovyJenfile.domain;

/**
 * 
 * @author jkchen
 *
 */
public class groovyScript {
	
	/**
	 * github 地址
	 */
	private String githubUrl;

	/**
	 * maven命令
	 */
	private String mavenBuild;
	
	public String getGithubUrl() {
		return githubUrl;
	}
	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}
	public String getMavenBuild() {
		return mavenBuild;
	}
	public void setMavenBuild(String mavenBuild) {
		this.mavenBuild = mavenBuild;
	}
	
	/**
	 * 重写toString()方法
	 */
	@Override
	public String toString() {
		return "Github Url: " + getGithubUrl() + ", Maven build：" + getMavenBuild();
	}
	
}
