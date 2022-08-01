package com.example.fastcampusprojectboard.service;

import com.example.fastcampusprojectboard.domain.type.SearchType;
import com.example.fastcampusprojectboard.dto.ArticleDto;
import com.example.fastcampusprojectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;


    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        return List.of();
    }


    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long id) {
        return null;
    }

    public Page<ArticleDto> pageSearchArticles(SearchType title, String search_keyword) {
        return Page.empty();
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updateArticle(long articleId, ArticleUpdateDto updateDto) {
    }

    public void deleteArticle(long articleId) {
    }
}
