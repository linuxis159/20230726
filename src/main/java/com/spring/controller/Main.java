package com.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
    //
    @RequestMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/search")
    //th:name="searchWord"
    public String search(@RequestParam("searchWord") String query)
    {
        return "main";
    }
}
