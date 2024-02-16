package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuTemplate{
    private String panelAuthID;
    private String panelAlias;
    private String panelLangPack;
    private String panelURL;
    private GridTemplate[] gridItems;
}
