package com.spring.mapper;

import com.spring.domain.Document;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocumentMapper {
    Document selectDocumentInTitle(String word);
}
