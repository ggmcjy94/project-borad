package com.example.fastcampusprojectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class ArticleComment extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article; // 게시글 (ID)

    @Setter
    @ManyToOne(optional = false)  // 이 항목은 false로 설정했을 때 해당 객체에 null이 들어갈 수 있습니다. 반대로 반드시 값이 필요하다면 true가 들어갑니다.
    @JoinColumn(name = "userId")
    private UserAccount userAccount; // 유저 정보 (ID)

    @Setter
    @Column(nullable = false, length = 500)
    private String content; // 본문



    protected ArticleComment() {
    }

    public ArticleComment(Article article, UserAccount userAccount, String content) {
        this.article = article;
        this.userAccount = userAccount;
        this.content = content;
    }

    public static ArticleComment of(Article article, UserAccount userAccount, String content) {
        return new ArticleComment(article, userAccount, content);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment articleComment)) return false;
        return id.equals(articleComment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
