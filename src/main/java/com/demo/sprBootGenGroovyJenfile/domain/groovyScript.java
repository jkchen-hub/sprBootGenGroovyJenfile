package com.demo.sprBootGenGroovyJenfile.domain;

public class groovyScript {

	private String githubUrl;

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
	
	//重写toString方法
	@Override
	public String toString() {
		return "Github Url: " + getGithubUrl() + ", maven项目命令是：" + getMavenBuild();
	}
	
}
