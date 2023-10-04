package com.spring.controller;


import com.spring.domain.Document;
import com.spring.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class Main {
    private final SearchService searchService;
    @RequestMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/query")
    @ResponseBody
    public String[] search(@RequestParam("query") String query)
    {
        System.out.println("입력된 텍스트 : " +query);
        String[] titles = searchService.findTitlesByWord(query);
        return titles;
    }
}
/*    @GetMapping("/search")
    public Document search(@RequestParam("query") String query)
    {
        Document document = searchService.findDocBySearch(query);
        return document;
    }
}*/
