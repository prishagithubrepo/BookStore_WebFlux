package com.example.demo.service;

import com.example.demo.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface BookService {
	

	public Mono<Book> createBook(Book book);
	
	public Mono<Book> findBookById(int bookId);
	
	public Flux<Book> findAllBooks();
	
	public Mono<Book> updateBookDtls(Book book, int bookId);
	
	public Mono<Void> deleteBook(int bookId);	
	
	public Flux<Book> searchBooksByTitle(String title);

}
