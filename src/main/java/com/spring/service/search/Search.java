package com.spring.service.search;

import com.spring.domain.Document;

public interface Search {
    Document searchDocument(String word);
    String searchTitles(String word);


}
