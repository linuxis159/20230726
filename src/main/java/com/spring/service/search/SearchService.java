package com.spring.service.search;

import com.spring.domain.Document;
import com.spring.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    //private final SearchConfig searchConfig;
    private final DocumentMapper documentMapper;
/*
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
*/

    public String[] findTitlesByWord(String word) {
        return documentMapper.selectTitlesByWord(word);
    }

    public Document findDocByWord(String word) {
        return documentMapper.selectDocByWord(word);
    }
}
