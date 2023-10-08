package com.spring.template.menu.templateImpl;

import com.spring.dto.MenuTemplate;
import com.spring.template.JSFileTemplateAB;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.MenuJSFileType;


public class MenuControllerFileTemplate extends JSFileTemplateAB implements JSFileTemplateIF {

	public MenuControllerFileTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		super(menuTemplate, fileType);
	}

	@Override
	public String getTemplate() {
		
    	template = "Ext.define('"+ menuTemplate.getUrl() + menuFileType.getFileType() + "', {\n"
    			+ "    extend:'vc.view.common.base.ViewController',\r\n"
    			+ "    alias: 'controller."+getPanelName().toLowerCase()+"',\r\n"
    			+ "    // 조회조건으로 조회한다.\r\n"
    			+ "    \r\n"
    			+ "     onInit:function(me){\r\n"
    			+ "        me.getComp('searchArea').loadConditions(me);\r\n"
    			+ "        me.getCommonDataInSearchArea('searchArea');\r\n"
    			+ "        me.setCommonViewModelStore();\r\n"
    			+ "    },\r\n"
    			+ "\r\n"
    			+ "\r\n"
    			+ "})";
    	
		return template;
	}



}
