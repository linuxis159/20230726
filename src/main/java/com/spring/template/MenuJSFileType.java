package com.spring.template;


public enum MenuJSFileType {
	MenuPanel("", "MenuPanelFileTemplate"),
	MenuMainGrid("Main", "MenuMainGridFileTemplate"),
	MenuModel("Model", "MenuModelFileTemplate"),
	MenuController("Controller", "MenuControllerFileTemplate");
	
	private final String fileType;
	private final String impletationClassName;

	private MenuJSFileType(String fileType, String impletationClassName) {
		this.fileType = fileType;
		this.impletationClassName = impletationClassName;
	}

	public String getFileType() {
		return fileType;
	}
	public String getImpletationClassName() {
		return impletationClassName;
	}

}
