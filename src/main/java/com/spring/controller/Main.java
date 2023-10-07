package com.spring.controller;


import com.spring.domain.Document;
import com.spring.service.search.SearchService;
import com.spring.service.write.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Main {
    private final SearchService searchService;
    private final WriteService writeService;
    @RequestMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/searchTitle")
    public String[] searchTitle(@RequestParam("query") String query)
    {
        System.out.println("입력된 텍스트 : " +query);
        String[] titles = searchService.findTitlesByWord(query);
        return titles;
    }

    @GetMapping("/searchDoc")
    public Document searchDoc(@RequestParam("query") String query)
    {
        System.out.println("입력된 텍스트 : " +query);
        Document doc = searchService.findDocByWord(query);
        return doc;
    }
    @PostMapping("/writeDocument")
    public void writeDoucment(@RequestBody Document requstedDocument){
        writeService.writeDocument(requstedDocument);

    }
}

