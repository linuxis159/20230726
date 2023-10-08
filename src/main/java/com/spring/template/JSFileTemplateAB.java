package com.spring.template;

import com.spring.dto.MenuTemplate;
import com.spring.dto.PopTemplate;
import lombok.Getter;

@Getter
public abstract class JSFileTemplateAB {
	protected String url;
	protected String panelName;
	protected String popName;
	protected String fileName;
	protected MenuJSFileType menuFileType;
	protected PopJSFileType popFileType;
	protected String template;
	protected MenuTemplate menuTemplate;
	protected PopTemplate popTemplate;
	
	public JSFileTemplateAB(MenuTemplate menuTemplate, MenuJSFileType menuFileType) {
		this.menuTemplate = menuTemplate;
		this.menuFileType = menuFileType;
		this.fileName = getLastWordByUrl(menuTemplate.getUrl()) + menuFileType.getFileType();
		this.panelName = getLastWordByUrl(menuTemplate.getUrl());
	}

	public JSFileTemplateAB(PopTemplate popTemplate, PopJSFileType popFileType) {
		this.popTemplate = popTemplate;
		this.popFileType = popFileType;
		this.fileName = getLastWordByUrl(popTemplate.getUrl()) + popFileType.getFileType();
		this.popName = getLastWordByUrl(popTemplate.getUrl());
	}
	
	private String getLastWordByUrl(String url) {
		String[] splitedUrl= url.split("\\.");
		return splitedUrl[splitedUrl.length-1];
	}

	

	
}
