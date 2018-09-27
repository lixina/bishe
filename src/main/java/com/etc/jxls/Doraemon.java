package com.etc.jxls;

import java.util.List;

public class Doraemon {
	
	private String name;
	private List<Tool> tool;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Tool> getTool() {
		return tool;
	}
	public void setTool(List<Tool> tool) {
		this.tool = tool;
	}
	public Doraemon(String name, List<Tool> tool) {
		super();
		this.name = name;
		this.tool = tool;
	}
	
	public Doraemon() {
	}
}
