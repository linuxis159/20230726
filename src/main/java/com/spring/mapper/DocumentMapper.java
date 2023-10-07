package com.spring.mapper;

import com.spring.domain.Document;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DocumentMapper {
    @Select("SELECT *  FROM \"Doc\" WHERE \"Title\" LIKE '%' || #{word} || '%'")
    String[] selectTitlesByWord(String word);

    @Select("SELECT *  FROM \"Doc\" WHERE \"Title\" =  #{word}")
    Document selectDocByWord(String word);

    @Insert("INSERT INTO public.\"Doc\"\n" +
            "(\"Title\", \"Desc\", \"CreateUser\", \"CreateDate\", \"DocumentId\")\n" +
            "VALUES( #{title},  #{desc}, 'user', now(), nextVal('documentId'))")
    int insertDoc(Document document);
}
