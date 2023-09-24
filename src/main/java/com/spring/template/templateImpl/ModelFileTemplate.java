package com.spring.template.templateImpl;

import com.spring.dto.MenuTemplate;
import com.spring.template.MenuJSFileTemplateAB;
import com.spring.template.MenuJSFileTemplateIF;
import com.spring.template.MenuJSFileType;

public class ModelFileTemplate extends MenuJSFileTemplateAB implements MenuJSFileTemplateIF {

	public ModelFileTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		super(menuTemplate, fileType);
	}

	@Override
	public String getTemplate() {
	  	template = "Ext.define('"+ menuTemplate.getUrl() + fileType.getFileType() + "', {\n"
    			+ "    extend:'Ext.app.ViewModel', \r\n"
    			+ "    alias: 'viewmodel."+getPanelName().toLowerCase()+"',\r\n"
    			+ "    stores:{ \r\n"
    			+ "        // 상단 그리드 스토어(main)\r\n"
    			+ "        mainInfo:{\r\n"
    			+ "            fields:['field1'],\r\n"
    			+ "            proxy:{\r\n"
    			+ "                type:'ajax',\r\n"
    			+ "                url:'/"+getPanelName()+"Service/search',\r\n"
    			+ "                reader:{\r\n"
    			+ "                    type:'json',\r\n"
    			+ "                    rootProperty:'data.dsOut',\r\n"
    			+ "                    totalProperty:'dsTotalCount',\r\n"
    			+ "                    keepRawData:true\r\n"
    			+ "                }\r\n"
    			+ "            },\r\n"
    			+ "            autoLoad:false,\r\n"
    			+ "            pageSize:Util.rowPerPage\r\n"
    			+ "        },\r\n"
    			+ "    }\r\n"
    			+ "})";
	  	
		return template;
	}



}
