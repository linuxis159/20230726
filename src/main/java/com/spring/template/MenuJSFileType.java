package com.spring.template;

public enum MenuJSFileType {
	Panel("", "PanelFileTemplate"),
	MainGrid("Main", "MainGridFileTemplate"),
	Model("Model", "ModelFileTemplate"),
	Controller("Controller", "ControllerFileTemplate");
	
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
