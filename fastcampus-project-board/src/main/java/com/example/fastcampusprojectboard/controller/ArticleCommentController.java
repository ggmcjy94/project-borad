package com.example.fastcampusprojectboard.controller;


import com.example.fastcampusprojectboard.dto.UserAccountDto;
import com.example.fastcampusprojectboard.dto.request.ArticleCommentRequest;
import com.example.fastcampusprojectboard.service.ArticleCommentService;
import com.example.fastcampusprojectboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.fastcampusprojectboard.domain.QArticle.article;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;


    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {

        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "uno", "pw", "uno@email.con", null, null
        )));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {

        articleCommentService.deleteArticleComment(commentId);

        return "redirect:/articles/" + articleId;
    }



}
