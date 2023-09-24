package com.spring.template;

import com.spring.dto.MenuTemplate;

public class FileTemplateFactory {
	static MenuJSFileTemplateIF createTemplate(MenuTemplate menuTemplate, MenuJSFileType fileType) {
		switch(fileType) {
		case Panel:
			return new PanelFileTemplate(menuTemplate, fileType);
		case MainGrid:
			return new MainGridFileTemplate(menuTemplate, fileType);
		case Controller:
			return new ControllerFileTemplate(menuTemplate, fileType);
		case Model:
			return new ModelFileTemplate(menuTemplate, fileType);
		}
        return null;
		
	}
}