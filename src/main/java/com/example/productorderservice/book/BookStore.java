package com.example.productorderservice.book;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
// 다대일(book : bookStore) 관계
// 일
public class BookStore {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    // 양방향인 경우
    @OneToMany(mappedBy = "bookStore")
    private Set<Book> books = new HashSet<>();

    public void add(Book book) {
//        book.setBookStore(this);
        this.books.add(book);
    }
}
