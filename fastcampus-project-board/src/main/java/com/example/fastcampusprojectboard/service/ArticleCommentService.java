package com.example.fastcampusprojectboard.service;

import com.example.fastcampusprojectboard.domain.Article;
import com.example.fastcampusprojectboard.domain.UserAccount;
import com.example.fastcampusprojectboard.dto.ArticleCommentDto;
import com.example.fastcampusprojectboard.repository.ArticleCommentRepository;
import com.example.fastcampusprojectboard.repository.ArticleRepository;
import com.example.fastcampusprojectboard.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.articleId());
            UserAccount userAccount = userAccountRepository.getReferenceById(dto.userAccountDto().userId());
            articleCommentRepository.save(dto.toEntity(article, userAccount));
        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
        }
    }

    public void deleteArticleComment(Long articleCommentId, String userId) {
        articleCommentRepository.deleteByIdAndUserAccount_UserId(articleCommentId, userId);
    }
}
