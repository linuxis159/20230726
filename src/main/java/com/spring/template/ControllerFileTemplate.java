package com.spring.template;

import com.spring.dto.MenuTemplate;

public class ControllerFileTemplate extends MenuJSFileTemplateAB implements MenuJSFileTemplateIF{

	public ControllerFileTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		super(menuTemplate, fileType);
	}

	@Override
	public String getTemplate() {
		
    	template = "Ext.define('"+ url + fileType.getFileType() + "', {\n"
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

	@Override
	void checkJSSyntex() {
		// TODO Auto-generated method stub
		
	}

}
