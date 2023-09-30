package com.spring.controller;


import com.spring.domain.Document;
import com.spring.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class Main {
    private final SearchService searchService;
    @RequestMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/search")
    public Document search(@RequestParam("searchWord") String query)
    {
        Document document = searchService.findDocBySearch(query);
        return document;
    }
}
