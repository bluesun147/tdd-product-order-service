package com.example.productorderservice.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
    @Autowired
    BookStoreRepository bookStoreRepository;    

    @Autowired
    BookRepository bookRepository;

    @Test
    public void contextLoads() {
        BookStore bookStore = new BookStore();
        bookStore.setName("시애틀 책방");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("책 제목2");
        book.setIsbn("12345");

        bookStore.add(book);
        book.setBookStore(bookStore);
        bookRepository.save(book);
    }
}
