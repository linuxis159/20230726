package com.spring.template.templateImpl;

import com.spring.dto.MenuTemplate;
import com.spring.template.MenuJSFileTemplateAB;
import com.spring.template.MenuJSFileTemplateIF;
import com.spring.template.MenuJSFileType;

public class MainGridFileTemplate extends MenuJSFileTemplateAB implements MenuJSFileTemplateIF {

	public MainGridFileTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		super(menuTemplate, fileType);
	}

	@Override
	public String getTemplate() {
    	template = "Ext.define('"+ menuTemplate.getUrl() + fileType.getFileType() + "', {\n" +
                "    extend: 'vc.view.common.widget.ExGridEditor',\n" +
                "    alias: 'widget."+this.getFileName().toLowerCase()+"',\n" +
                "    selModel: 'rowmodel',\n" +
                "    dockedItems: [\n" +
                "        {\n" +
                "            xtype: 'toolbar',\n" +
                "            layout: 'hbox',\n" +
                "            items: [{\n" +
                "                xtype: 'exgridpagecontrol'\n" +
                "            }, {\n" +
                "                xtype: 'container',\n" +
                "                flex: 1\n" +
                "            }, {\n" +
                "                xtype: 'exbutton',\n" +
                "                textEx: 'BTN_ADD',\n" +
                "                type: 'gridAdd'\n" +
                "            }, {\n" +
                "                xtype: 'exbutton',\n" +
                "                textEx: 'BTN_SAVE',\n" +
                "                type: 'gridSave'\n" +
                "            }, {\n" +
                "\t\t\t\txtype: 'exbutton', textEx: 'BTN_EXCEL',\n" +
                "\t\t\t\tmenu : [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\ttextEx: 'BTN_EXCEL_DOWN_ALL', type: 'gridExcelAll'\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\ttextEx: 'BTN_EXCEL_DOWN_GRID', type: 'gridExcel'\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t\t/** , {\n" +
                "\t\t\t\t\t\ttextEx: 'BTN_EXCEL_SHEET', type: 'gridSpread'\n" +
                "\t\t\t\t\t}*/\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t}]\n" +
                "        }],\n" +
                "    columns: [\n" +
                "        {\n" +
                "            xtype: 'exrownumberercolumn',\n" +
                "            align: 'right'\n" +
                "        }, {\n" +
                "            xtype: '', //excolumn, excolumneditor \n" +
                "            textEx: '',\n" +
                "            dataIndex: '',\n" +
                "            align: '',\n" +
                "            editType: 'text', //text, combo, popcode \n" +
                "            locked: false,\n" +
                "            width: 150,\n" +
                "            editDisabled: false,\n" +
                "            validators: {\n" +
                "                required: false,\n" +
                "\n" +
                "            }\n" +
                "        }, {\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: '',\n" +
                "            dataIndex: '',\n" +
                "            editType: 'combo',\n" +
                "            bindStore: '',\n" +
                "            displayField: '',\n" +
                "            valueField: '',\n" +
                "            excelPrint : true,\n" +
                "            width: 150,\n" +
                "            editDisabled: false,\n" +
                "\t\t\tinsertDisabled: false,\n" +
                "\t\t\thidden : true\n" +
                "        },{\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: 'POP_CODE',\n" +
                "            dataIndex: '',\n" +
                "            align: '',\n" +
                "            editType: 'popcode',\n" +
                "            sqlProp: '',\n" +
                "            displayField: 'displayField',\n" +
                "            locked: false,\n" +
                "            excelPrint : true,\n" +
                "            width: 150,\n" +
                "            editDisabled: false,\n" +
                "\t\t\tinsertDisabled: false,\n" +
                "            validators: {\n" +
                "                required: false,\n" +
                "                max: 60\n" +
                "            }\n" +
                "        }, {\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: 'POP_NAME',\n" +
                "            dataIndex: 'displayField',\n" +
                "            editType: 'text',\n" +
                "            locked: false,\n" +
                "            hidden: false,\n" +
                "            width: 150,\n" +
                "            editDisabled: true,\n" +
                "            validators: {\n" +
                "                max: 60\n" +
                "            }\n" +
                "        }, {\n" +
                "            xtype: 'excolumndel'\n" +
                "        }, {\n" +
                "            xtype: 'excolumneditstatus'\n" +
                "        }, {\n" +
                "            xtype: 'excolumneditor',\n" +
                "            textEx: 'LBL_INSERT_PERSON_ID',\n" +
                "            dataIndex: 'CRE_USR_ID',\n" +
                "            editType: 'text',\n" +
                "            excelPrint : false,\n" +
                "            width: 150,\n" +
                "            align: 'center',\n" +
                "            editDisabled: true,\n" +
                "            insertDisabled: true\n" +
                "        },{\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: 'LBL_INSERT_DATE',\n" +
                "            dataIndex: 'CRE_DTTM',\n" +
                "            editType: 'text',\n" +
                "            excelPrint : false,\n" +
                "            width: 150,\n" +
                "            align: 'center',\n" +
                "            editDisabled: true,\n" +
                "            insertDisabled: true\n" +
                "        },{\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: 'LBL_UPDATE_PERSON_ID',\n" +
                "            dataIndex: 'UPD_USR_ID',\n" +
                "            editType: 'text',\n" +
                "            excelPrint : false,\n" +
                "            width: 150,\n" +
                "            align: 'center',\n" +
                "            editDisabled: true,\n" +
                "            insertDisabled: true\n" +
                "        },{\n" +
                "            xtype: 'excolumn',\n" +
                "            textEx: 'LBL_UPDATE_TIME',\n" +
                "            dataIndex: 'UPD_DTTM',\n" +
                "            editType: 'text',\n" +
                "            excelPrint : false,\n" +
                "            width: 150,\n" +
                "            align: 'center',\n" +
                "            editDisabled: true,\n" +
                "            insertDisabled: true\n" +
                "        }]\n" +
                "});\n";
		return template;
	}



}
