package com.example.fastcampusprojectboard.repository.querydsl;

import com.example.fastcampusprojectboard.domain.Article;
import com.example.fastcampusprojectboard.domain.QArticle;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public ArticleRepositoryCustomImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {

        QArticle article = QArticle.article;

        return from(article)
                // 중복 방지
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull()).fetch();
    }
}
