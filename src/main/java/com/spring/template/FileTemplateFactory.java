package com.spring.template;

import com.spring.dto.MenuTemplate;
import com.spring.dto.PopTemplate;
import com.spring.template.menu.templateImpl.MenuControllerFileTemplate;
import com.spring.template.menu.templateImpl.MenuMainGridFileTemplate;
import com.spring.template.menu.templateImpl.MenuModelFileTemplate;
import com.spring.template.menu.templateImpl.MenuPanelFileTemplate;
import com.spring.template.pop.templateImpl.PopControllerFileTemplate;
import com.spring.template.pop.templateImpl.PopFileTemplate;
import com.spring.template.pop.templateImpl.PopModelFileTemplate;


public class FileTemplateFactory {
	static JSFileTemplateIF createMenuTemplate(MenuTemplate menuTemplate, MenuJSFileType menuFileType) {
		switch(menuFileType) {
		case MenuPanel:
			return new MenuPanelFileTemplate(menuTemplate, menuFileType);
		case MenuMainGrid:
			return new MenuMainGridFileTemplate(menuTemplate, menuFileType);
		case MenuController:
			return new MenuControllerFileTemplate(menuTemplate, menuFileType);
		case MenuModel:
			return new MenuModelFileTemplate(menuTemplate, menuFileType);
		}
        return null;
		
	}

	static JSFileTemplateIF createPopTemplate(PopTemplate popTemplate, PopJSFileType popFileType) {
		switch(popFileType) {
			case Pop:
				return new PopFileTemplate(popTemplate, popFileType);
			case PopController:
				return new PopControllerFileTemplate(popTemplate, popFileType);
			case PopModel:
				return new PopModelFileTemplate(popTemplate, popFileType);
		}
		return null;

	}
}
