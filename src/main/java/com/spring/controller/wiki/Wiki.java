package com.spring.controller.wiki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wiki")
public class Wiki {
    @RequestMapping("/search")
    public String search(String searchKeyword){
        return "";
    }
}
