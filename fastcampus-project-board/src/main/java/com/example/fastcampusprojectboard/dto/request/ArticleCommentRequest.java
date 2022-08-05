package com.example.fastcampusprojectboard.dto.request;

import com.example.fastcampusprojectboard.dto.ArticleCommentDto;
import com.example.fastcampusprojectboard.dto.UserAccountDto;

import java.io.Serializable;

public record ArticleCommentRequest(Long articleId, String content) implements Serializable {


    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}
