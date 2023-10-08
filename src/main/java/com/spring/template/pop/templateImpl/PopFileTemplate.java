package com.spring.template.pop.templateImpl;

import com.spring.dto.PopTemplate;
import com.spring.template.JSFileTemplateAB;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.PopJSFileType;


public class PopFileTemplate extends JSFileTemplateAB implements JSFileTemplateIF {
	
	public PopFileTemplate(PopTemplate popTemplate, PopJSFileType fileType) {
		super(popTemplate, fileType);
	}

	@Override
	public String getTemplate() {
		template = "Ext.define('"+ popTemplate.getUrl() + popFileType.getFileType() + "', {\n" +
				"    extend:'vc.view.common.widget.container.ExWindowMain',\n" +
				"    alias:'widget."+fileName.toLowerCase()+"',\r\n" +
				"    requires:['"+popTemplate.getUrl()+"Controller',\r\n" +
				"              '"+popTemplate.getUrl()+"Model',\r\n" +
				"              '"+popTemplate.getUrl()+"Main'],\r\n" +
				"    controller:'"+fileName.toLowerCase()+"',\r\n" +
				"    viewModel:{\r\n" +
				"        type:'"+fileName.toLowerCase()+"'\r\n" +
				"    },\r\n" +
				"    modal:true,\n" +
				"    layout:{\n" +
				"        type:'vbox',\n" +
				"        align:'stretch'\n" +
				"    },\n" +
				"    width:800,\n" +
				"    height:700,\n" +
				"        title:Lang.get('LBL_"+popTemplate.getMenuLangPack()+"'),\r\n" +
				"\n" +
				"    items:[{\n" +
				"        xtype:'exform',\n" +
				"        reference:'mainForm',\n" +
				"        layout:{\n" +
				"            type:'hbox',\n" +
				"            align:'stretch'\n" +
				"        },\n" +
				"        flex:2,\n" +
				"        items:[{\n" +
				"                xtype : 'exgrideditor',\n" +
				"                flex:4,\n" +
				"                reference : 'leftGrid',\n" +
				"                region: 'left',\n" +
				"                bind : {\n" +
				"                    store : '{mainInfo}'\n" +
				"                },\n" +
				"                listeners:{\n" +
				"                    itemdblclick:'onLeftGridDbClick'\n" +
				"                },\n" +
				"                selModel: {\n" +
				"                    selType: 'checkboxmodel',\n" +
				"                    mode: 'MULTI',   // SINGLE :한건, MULTI:여러건  (라디오 버튼은 안됨.)\n" +
				"                    checkOnly: 'true',\n" +
				"                    allowDeselect: true\n" +
				"                },\n" +
				"                dockedItems:[{\n" +
				"                    xtype:'toolbar',\n" +
				"                    items:[{\n" +
				"                        xtype:'container',\n" +
				"                        flex:1\n" +
				"                    },{\n" +
				"                        xtype:'exbutton',\n" +
				"                        textEx:\"BTN_ADD\",\n" +
				"                        handler:'onAdd'\n" +
				"                    }\n" +
				"                    ]\n" +
				"                }],\n" +
				"                columns:[{ //사용자그룹명\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USR_GRP_NM',\n" +
				"                    dataIndex:'USR_GRP_CD',\n" +
				"                    align: 'left',\n" +
				"                    items:[{\n" +
				"                        xtype: 'exsearchtrigger',\n" +
				"                    }],\n" +
				"                },{ //사용자아이디\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USER_ID',\n" +
				"                    dataIndex:'USR_ID',\n" +
				"                    align :'left',\n" +
				"                    items:[{\n" +
				"                        xtype: 'exsearchtrigger',\n" +
				"                    }],\n" +
				"                },{ // 위반알림최대횟수\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USER_NAME',\n" +
				"                    dataIndex:'USR_NM',\n" +
				"                    align :'left',\n" +
				"                    items:[{\n" +
				"                        xtype: 'exsearchtrigger',\n" +
				"                    }],\n" +
				"                }]\n" +
				"            },\n" +
				"            {\n" +
				"                xtype : 'container',\n" +
				"                flex : 1,\n" +
				"                layout : {\n" +
				"                    type: 'vbox',\n" +
				"                    align : 'center'\n" +
				"                }\n" +
				"            },{\n" +
				"                xtype : 'exgrideditor',\n" +
				"                flex:4,\n" +
				"                reference : 'rightGrid',\n" +
				"                region: 'right',\n" +
				"                saveUrl: '/vltnNtfctnCnfgService/saveReceivingUser',\n" +
				"                bind : {\n" +
				"                    store : '{rightGridStore}'\n" +
				"                },\n" +
				"                listeners:{\n" +
				"                    itemdblclick:'onRightGridDbClick'\n" +
				"                },\n" +
				"                selModel: {\n" +
				"                    selType: 'checkboxmodel',\n" +
				"                    mode: 'MULTI',   // SINGLE :한건, MULTI:여러건  (라디오 버튼은 안됨.)\n" +
				"                    checkOnly: 'true',\n" +
				"                    allowDeselect: true\n" +
				"                },\n" +
				"                dockedItems:[{\n" +
				"                    xtype:'toolbar',\n" +
				"                    items:[{\n" +
				"                        xtype:'container',\n" +
				"                        flex:1\n" +
				"                    },{\n" +
				"                        xtype:'exbutton',\n" +
				"                        textEx:\"LBL_DELETE\",\n" +
				"                        handler:'onDelete'\n" +
				"                    },{\n" +
				"                        xtype:'exbutton',\n" +
				"                        textEx:\"BTN_SAVE\",\n" +
				"                        handler:'onSave'\n" +
				"                    }\n" +
				"                    ]\n" +
				"                }],\n" +
				"                columns:[{ //사용자그룹명\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USR_GRP_NM',\n" +
				"                    dataIndex:'USR_GRP_CD',\n" +
				"                    align: 'left',\n" +
				"                },{ //사용자아이디\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USER_ID',\n" +
				"                    dataIndex:'USR_ID',\n" +
				"                    align :'left',\n" +
				"                },{ // 위반알림최대횟수\n" +
				"                    xtype:'excolumn',\n" +
				"                    textEx:'LBL_USER_NAME',\n" +
				"                    dataIndex:'USR_NM',\n" +
				"                    align :'left',\n" +
				"                }]\n" +
				"            }]\n" +
				"\n" +
				"    }]\n" +
				"});\n";
		return template;
	}


	

}
