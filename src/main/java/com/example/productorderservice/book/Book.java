package com.example.productorderservice.book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
// 다대일(book : bookStore) 양방향 관계
// 양방향 관계에서 주의해야 할 점
// 다
// 연관 관계 주인
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String isbn;
    private String title;

    @ManyToOne
    private BookStore bookStore;
}