package com.spring.template.pop.templateImpl;

import com.spring.dto.PopTemplate;
import com.spring.template.JSFileTemplateAB;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.PopJSFileType;


public class PopModelFileTemplate extends JSFileTemplateAB implements JSFileTemplateIF {

	public PopModelFileTemplate(PopTemplate popTemplate, PopJSFileType fileType) {
		super(popTemplate, fileType);
	}

	@Override
	public String getTemplate() {
	  	template = "Ext.define('"+ popTemplate.getUrl() + popFileType.getFileType() + "', {\n" +
				"    extend:'Ext.app.ViewModel',\n" +
				"    alias: 'viewmodel."+getPopName().toLowerCase()+"',\r\n" +
				"    stores: {\n" +
				"        mainInfo: {\n" +
				"            fields: ['field1'],\n" +
				"            proxy: {\n" +
				"                type: 'ajax',\n" +
				"                url:'/"+getPopName()+"Service/search',\r\n" +
				"                reader:{\n" +
				"                    type: 'json',\n" +
				"                    rootProperty: 'data.dsOut',\n" +
				"                    totalProperty: 'dsTotalCount',\n" +
				"                    keepRawData: true\n" +
				"                }\n" +
				"            },\n" +
				"            autoLoad: false,\n" +
				"            pageSize: Util.rowPerPage\n" +
				"        },\n" +
				"        rightGridStore: {\n" +
				"            fields: ['field1'],\n" +
				"        }\n" +
				"    }\n" +
				"});";
	  	
		return template;
	}



}
