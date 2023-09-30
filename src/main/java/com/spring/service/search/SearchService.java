package com.spring.service.search;

import com.spring.domain.Document;
import com.spring.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchConfig searchConfig;
    public Document findDocBySearch(String word) {


        List<Search> searchList = searchConfig.getSearchChain();

        Document document = null;
        for(Search search : searchList){
            document = search.search(word);
            if(document != null)
                break;
        }
        return document;

    }
}
