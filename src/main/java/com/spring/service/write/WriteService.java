package com.spring.service.write;

import com.spring.domain.Document;
import com.spring.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteService {
    private final DocumentMapper documentMapper;
    public void writeDocument(Document document){
        documentMapper.insertDoc(document);

    }
}
