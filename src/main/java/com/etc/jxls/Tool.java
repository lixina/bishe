package com.etc.jxls;

public class Tool {
	
	private String toolName;
	private String toolFunction;
	
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getToolFunction() {
		return toolFunction;
	}
	public void setToolFunction(String toolFunction) {
		this.toolFunction = toolFunction;
	}
	
	public Tool(String toolName, String toolFunction) {
		super();
		this.toolName = toolName;
		this.toolFunction = toolFunction;
	}
	
	public Tool() {
	}
}
