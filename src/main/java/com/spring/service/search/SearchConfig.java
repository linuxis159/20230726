package com.spring.service.search;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Configuration
public class SearchConfig {
    private final SearchInTitle searchInTitle;
    private final List<Search> searchChain;
    private final List<Search> unmodifiableList;

    public SearchConfig(SearchInTitle searchInTitle){
        this.searchInTitle = searchInTitle;
        searchChain = new ArrayList();

        searchChain.add(searchInTitle);
        unmodifiableList = Collections.unmodifiableList(searchChain);
    }

    public List<Search> getSearchChain() {
        return unmodifiableList;
    }
}
