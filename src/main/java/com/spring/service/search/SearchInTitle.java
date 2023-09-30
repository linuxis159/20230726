package com.spring.service.search;

import com.spring.domain.Document;
import com.spring.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SearchInTitle implements Search{
    private final DocumentMapper documentMapper;

    @Override
    public Document search(String word) {
        documentMapper.selectDocumentInTitle(word);
        return documentMapper.selectDocumentInTitle(word);
    }
}
