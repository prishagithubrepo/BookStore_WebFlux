package com.example.demo.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Mono<Book> createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Mono<Book> findBookById(int bookId) {
		return bookRepository.findById(bookId);
	}

	@Override
	public Flux<Book> findAllBooks() {
		return bookRepository.findAll();
				/*.delayElements(Duration.ofSeconds(2))
				.log();*/
	}

	@Override
	public Mono<Book> updateBookDtls(Book book, int bookId) {
		Mono<Book> oldBook = bookRepository.findById(bookId);
		return oldBook.flatMap(newBook -> {
			newBook.setName(book.getName());
			newBook.setDescription(book.getDescription());
			newBook.setPublisher(book.getPublisher());
			newBook.setAuthor(book.getAuthor());
			return bookRepository.save(newBook);
		});
	}

	@Override
	public Mono<Void> deleteBook(int bookId) {
		Mono<Book> book = bookRepository.findById(bookId);
		return book.flatMap(book1 -> bookRepository.delete(book1));
	}

	@Override
	public Flux<Book> searchBooksByTitle(String title) {
		
		return this.bookRepository.searchBookByTitle("%"+title+"%");
	}
	
	

}
