package com.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("메인페이지 로딩")
    public void loadMainPage() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        System.out.println(response.getBody());

        Assertions.assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }

}