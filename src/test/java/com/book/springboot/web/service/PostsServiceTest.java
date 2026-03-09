package com.book.springboot.web.service;

import com.book.springboot.web.domain.posts.Posts;
import com.book.springboot.web.domain.posts.PostsRepository;
import com.book.springboot.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class PostsServiceTest {
    @InjectMocks
    private PostsService postsService;

    @Mock
    private PostsRepository postsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        // Given
        Posts post = Posts.builder()
                .title("Test title")
                .content("Test content")
                .author("Test author")
                .build();
        when(postsRepository.save(any(Posts.class))).thenReturn(post);

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("Test title")
                .content("Test content")
                .author("Test author")
                .build();

        // When
        Long postId = postsService.save(dto);

        // Then
        assertThat(postId).isEqualTo(post.getId());
    }
}