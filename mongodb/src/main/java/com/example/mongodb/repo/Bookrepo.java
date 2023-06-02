package com.example.mongodb.repo;
import  com.example.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Bookrepo extends MongoRepository<Book,Integer>{

}
