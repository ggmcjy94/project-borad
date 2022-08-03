//package com.example.fastcampusprojectboard.service;
//
//import com.example.fastcampusprojectboard.domain.Article;
//import com.example.fastcampusprojectboard.repository.ArticleCommentRepository;
//import com.example.fastcampusprojectboard.repository.ArticleRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.mysema.commons.lang.Assert.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.then;
//
//
//@Disabled
//@DisplayName("비즈니스 로직 - 게시글")
//@ExtendWith(MockitoExtension.class)
//class ArticleCommentServiceTest {
//
//    @InjectMocks
//    private ArticleCommentService sut;
//
//    @Mock
//    private ArticleRepository articleRepository;
//    @Mock
//    private ArticleCommentRepository articleCommentRepository;
//
//
//    @DisplayName("게시글 Id 로 조회하면 , 해당하는 댓글 리스트로 반환한다.")
//    @Test
//    void givenArticleId_whenSearchingComments_thenReturnsArticleComments() {
//        //given
//        Long articleId = 1L;
//
////        given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title", "content", "#java")));
////        //when
////        List<ArticleCommentDto> articleComments = sut.searchArticleComment(1L);
//        //then
//        assertThat(articleComments).isNotNull();
//        then(articleRepository).should().findById(articleId);
//
//    }
//
//
//    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
//    @Test
//    void givenArticleId_whenSearchingComments_thenReturnsArticleCommentss() {
//        //given
//        Long articleId = 1L;
//        given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title", "content", "#java")));
//
//        //when
//        List<ArticleCommentDto> articleComments = sut.searchArticleComment(1L);
//
//        //then
//        assertThat(articleComments).isNotNull();
//        then(articleRepository).should().findById(articleId);
//
//    }
//}