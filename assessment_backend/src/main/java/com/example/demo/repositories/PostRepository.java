package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.List;

@Repository
public class PostRepository {
    
    private static final String  SQL_INSERT_SECONDHAND = "INSERT INTO postings (posting_id,posting_date,name,email,phone,title,description,image)";

    @Autowired
    private JdbcTemplate template;

    public Boolean insertPosting (List l){
        int count = template.update(SQL_INSERT_SECONDHAND,l.getPostingID(),l.getPostingDate(),l.getName(),l.getEmail(),l.getPhone(),l.getTitle(),l.getDescription(),l.getImage());

        if(count == 0)
            return false;
        else 
            return true;
    }
}
