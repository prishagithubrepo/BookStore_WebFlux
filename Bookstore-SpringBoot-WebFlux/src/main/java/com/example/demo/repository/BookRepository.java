package com.example.demo.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {
	
	public Mono<Book> findByName(String name);
	
	@Query("select * from book_details where name = :name and author = :author")
	public Flux<Book> findByNameAndAuthor(String name, String author);
	
	@Query("select * from book_details where name LIKE :title")
	public Flux<Book> searchBookByTitle(String title);

}
