package com.example.fastcampusprojectboard.service;

import com.example.fastcampusprojectboard.domain.Article;
import com.example.fastcampusprojectboard.domain.type.SearchType;
import com.example.fastcampusprojectboard.dto.ArticleDto;
import com.example.fastcampusprojectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        //given
        // when
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목 본문 ID 닉네임 해시태그

        //Then
        assertThat(articles).isNotNull();
    }


    @DisplayName("게시글을 조회하면, 게시글을 반환한다. ")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        //given
        // when
        ArticleDto article = sut.searchArticle(1L); // 제목 본문 ID 닉네임 해시태그

        //Then
        assertThat(article).isNotNull();
    }


    @DisplayName("페이징 기능, 페이지 리스트를 반환")
    @Test
    void givenPageSearchParameters_whenPageSearchingArticles_thenReturnsPageArticleList() {
        //given
        // when
        Page<ArticleDto> articles = sut.pageSearchArticles(SearchType.TITLE, "search keyword"); // 제목 본문 ID 닉네임 해시태그

        //Then
        assertThat(articles).isNotNull();
    }


    @DisplayName("게시글 정보를 입력하면 게시글을 생성한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        //given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "Uno", "title", "content", "#hashtag"));

        //Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 정보를 입력하면 게시글을 수정한다.")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        //given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#hashtag"));

        //Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 정보를 입력하면 게시글을 수정한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        //given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        //when
        sut.deleteArticle(1L);

        //Then
        then(articleRepository).should().delete(any(Article.class));
    }
}