package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	/*public void findMethoTest() {
		Mono<Book> book = bookRepository.findByName("Spring Boot WebFlux");
		
		StepVerifier.create(book)
					.expectNextCount(1)
					.verifyComplete();
		
	}
	
	public void queryMethodTest() {
		bookRepository.findByNameAndAuthor("Spring Boot WebFlux","Priyanka")
				.as(StepVerifier::create)
				.expectNextCount(1)
				.expectComplete();
		
		}*/
	@Test
	public void searchQueryMethodTest() {
		bookRepository.searchBookByTitle("%Boot%")
						.as(StepVerifier::create)
						.expectNextCount(1)
						.expectComplete();
	}
}
