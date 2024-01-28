package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Mono<Book> createBook(@RequestBody Book book){
		return bookService.createBook(book);		
	}
	
	@GetMapping
	public Flux<Book> findAllBooks(){
		return bookService.findAllBooks();
	}
	
	@GetMapping("{bid}")
	public Mono<Book> findBookById(@PathVariable("bid") int bookId){
		return bookService.findBookById(bookId);
	}

	@PutMapping("{bookId}")
	public Mono<Book> updateBookDtls(@RequestBody Book book, @PathVariable int bookId){
		return bookService.updateBookDtls(book, bookId);
	}
	
	@DeleteMapping("{bookId}")
	public Mono<Void> deleteBook(@PathVariable int bookId){
		return bookService.deleteBook(bookId);
	}
	
	@GetMapping("/search")
	public Flux<Book> searchBooks(@RequestParam("query") String query){
		
        System.out.println(query);

		return this.bookService.searchBooksByTitle(query);
	}

}
