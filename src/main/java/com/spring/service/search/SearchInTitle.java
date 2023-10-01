package com.spring.service.search;

import com.spring.domain.Document;
import com.spring.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SearchInTitle{
    private final DocumentMapper documentMapper;


    public String[] searchTitles(String word) {
        String[] titles = documentMapper.selectTitlesByWord(word);
        return titles;
    }
}
