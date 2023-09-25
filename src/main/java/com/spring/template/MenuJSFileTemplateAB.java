package com.spring.template;

import com.spring.dto.MenuTemplate;
import lombok.Getter;

@Getter
public abstract class MenuJSFileTemplateAB {
	protected String url;
	protected String panelName;
	protected String fileName;
	protected MenuJSFileType fileType;
	protected String template;
	protected MenuTemplate menuTemplate;
	
	public MenuJSFileTemplateAB(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		this.menuTemplate = menuTemplate;
		this.fileType = fileType;
		this.fileName = getLastWordByUrl(menuTemplate.getUrl()) + fileType.getFileType();
		this.panelName = getLastWordByUrl(menuTemplate.getUrl());
	}
	
	private String getLastWordByUrl(String url) {
		String[] splitedUrl= url.split("\\.");
		return splitedUrl[splitedUrl.length-1];
	}

	

	
}
