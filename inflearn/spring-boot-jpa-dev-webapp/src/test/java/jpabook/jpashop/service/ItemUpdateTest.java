package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void updateTest() throws Exception {
        Book book = entityManager.find(Book.class, 1L);

        // TX
        book.setName("asdfasdf");

        // 변경감지 == dirty checking
    }
}
