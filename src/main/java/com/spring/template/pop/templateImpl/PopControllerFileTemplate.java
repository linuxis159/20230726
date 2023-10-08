package com.spring.template.pop.templateImpl;

import com.spring.dto.PopTemplate;
import com.spring.template.JSFileTemplateAB;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.PopJSFileType;


public class PopControllerFileTemplate extends JSFileTemplateAB implements JSFileTemplateIF {

	public PopControllerFileTemplate(PopTemplate popTemplate, PopJSFileType fileType) {
		super(popTemplate, fileType);
	}

	@Override
	public String getTemplate() {
		
    	template = "Ext.define('"+ popTemplate.getUrl() + popFileType.getFileType() + "', {\n" +
				"    extend: 'vc.view.common.base.ViewController',\n" +
				"    alias: 'controller."+getPopName().toLowerCase()+"',\r\n" +
				"    //초기함수\n" +
				"    onInit:function(me) {\n" +
				"        me.setCommonViewModelStore();\n" +
				"    },\n" +
				"    onCalled:function(callbackparamss) {\n" +
				"        var me = this;\n" +
				"        me.getComp('mainPop').search({});\n" +
				"    },\n" +
				"    onSave:function() {\n" +
				"        var me = this;\n" +
				"    }\n" +
				"\n" +
				"\n" +
				"});";
    	
		return template;
	}



}
