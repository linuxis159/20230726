package com.spring.template.menu.templateImpl;

import com.spring.dto.MenuTemplate;
import com.spring.template.JSFileTemplateAB;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.MenuJSFileType;


public class MenuPanelFileTemplate extends JSFileTemplateAB implements JSFileTemplateIF {
	
	public MenuPanelFileTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		super(menuTemplate, fileType);
	}

	@Override
	public String getTemplate() {
		template = "Ext.define('"+ menuTemplate.getUrl() + "', {\n"
    			+ "    extend:'vc.view.common.widget.container.ExPanelMain',\r\n"
    			+ "    alias:'widget."+fileName.toLowerCase()+"',\r\n"
    			+ "    requires:['"+menuTemplate.getUrl()+"Controller',\r\n"
    			+ "              '"+menuTemplate.getUrl()+"Model',\r\n"
    			+ "              '"+menuTemplate.getUrl()+"Main'],\r\n"
    			+ "    controller:'"+fileName.toLowerCase()+"',\r\n"
    			+ "    viewModel:{\r\n"
    			+ "        type:'"+fileName.toLowerCase()+"'\r\n"
    			+ "    },\r\n"
    			+ "    authId:'MENU_"+menuTemplate.getMenuCode()+"',\r\n"
    			+ "    items:[{\r\n"
    			+ "        region:'north',\r\n"
    			+ "        xtype:'expanelsrch',\r\n"
    			+ "        title:Lang.get('MENU_"+menuTemplate.getMenuCode()+"'),\r\n"
    			+ "        split:true,\r\n"
    			+ "    },{\r\n"
    			+ "    	split:true,\r\n"
    			+ "        region:'center',\r\n"
    			+ "        xtype:'"+(fileName+MenuJSFileType.MenuMainGrid.getFileType().toLowerCase())+"',\r\n"
    			+ "        reference:'mainGrid',\r\n"
    			+ "        authId:'MAIN_GRID_"+menuTemplate.getMenuCode()+"',\r\n"
    			+ "        editMode:'cell',                            // 그리드 셀 편집모드\r\n"
    			+ "        saveUrl:'/"+fileName.toLowerCase()+"Service/save',          // 저장시 URL\r\n"
    			+ "        searchCallback:'onMainInfoCallback',\r\n"
    			+ "        saveCallback:'onMainInfoSaveCallback', 	// 저장시 URL과 콜백 정의, 콜백이 필요없다면 정의하지 않는다.\r\n"
    			+ "        bind:{\r\n"
    			+ "            store:'{mainInfo}'\r\n"
    			+ "        },\r\n"
    			+ "        saveAfterMode :'refresh'\r\n"
    			+ "    }]\r\n"
    			+ "})";
		
		return template;
	}


	public String getTemplate(MenuTemplate[] menuTemplates) {
		template = "Ext.define('"+ menuTemplate.getUrl() + "', {\n"
				+ "    extend:'vc.view.common.widget.container.ExPanelMain',\r\n"
				+ "    alias:'widget."+fileName.toLowerCase()+"',\r\n"
				+ getRequires(menuTemplates)
				+ getPanelDefault()
				+ "    	split:true,\r\n"
				+ "        region:'center',\r\n"
				+ "        xtype:'"+(fileName+MenuJSFileType.MenuMainGrid.getFileType().toLowerCase())+"',\r\n"
				+ "        reference:'mainGrid',\r\n"
				+ "        authId:'MAIN_GRID_"+menuTemplate.getMenuCode()+"',\r\n"
				+ "        editMode:'cell',                            // 그리드 셀 편집모드\r\n"
				+ "        saveUrl:'/"+fileName.toLowerCase()+"Service/save',          // 저장시 URL\r\n"
				+ "        searchCallback:'onMainInfoCallback',\r\n"
				+ "        saveCallback:'onMainInfoSaveCallback', 	// 저장시 URL과 콜백 정의, 콜백이 필요없다면 정의하지 않는다.\r\n"
				+ "        bind:{\r\n"
				+ "            store:'{mainInfo}'\r\n"
				+ "        },\r\n"
				+ "        saveAfterMode :'refresh'\r\n"
				+ "    }]\r\n"
				+ "})";
				;

		return template;
	}
	String getRequires(MenuTemplate[] menuTemplates){
		String addtionalRequires = "    requires:['"+menuTemplate.getUrl()+"Controller',\r\n"
				+ "              '"+menuTemplate.getUrl()+"Model',\r\n"
				+ "              '"+menuTemplate.getUrl()+"Main'],\r\n";
		for(int i=0; i<menuTemplates.length; i++){
			addtionalRequires +="              '"+menuTemplate.getUrl()+ menuTemplate.getGridInfo()+"',\r\n";
		}
		return addtionalRequires;
	}
	String getPanelDefault(){
		String panelDefault ="    controller:'"+fileName.toLowerCase()+"',\r\n"
				+ "    viewModel:{\r\n"
				+ "        type:'"+fileName.toLowerCase()+"'\r\n"
				+ "    },\r\n"
				+ "    authId:'MENU_"+menuTemplate.getMenuCode()+"',\r\n"
				+ "    items:[{\r\n"
				+ "        region:'north',\r\n"
				+ "        xtype:'expanelsrch',\r\n"
				+ "        title:Lang.get('MENU_"+menuTemplate.getMenuCode()+"'),\r\n"
				+ "        split:true,\r\n"
				+ "    },\r\n";
		return panelDefault;
	}

	String getPanelGrid(MenuTemplate[] menuTemplates){
		String panelDefault = "";
		for(MenuTemplate menuTemplate : menuTemplates){
			if(menuTemplate.getGridInfo().equals("Container")){

			}
			else if(menuTemplate.getGridInfo().equals("TabPanel")){

			}
		}
		return panelDefault;
	}


	

}
