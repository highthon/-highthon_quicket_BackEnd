package com.example.dokgodieserver.domain.article.domain;

import com.example.dokgodieserver.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotNull
    private String title;

    @Column(length = 1000)
    @NotNull
    private String articleLink;

    @NotNull
    private String reels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Article(String title, String articleLink, String reels,User user) {
        this.title = title;
        this.articleLink = articleLink;
        this.user = user;
        this.reels = reels;
    }

}
