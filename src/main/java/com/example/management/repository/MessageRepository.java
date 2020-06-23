package com.example.management.repository;

import com.example.management.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    /**
     * find message Order By Title Asc
     * @return java.util.ArrayList
     */
    public List<Message> findByOrderByTitleAsc();

}
