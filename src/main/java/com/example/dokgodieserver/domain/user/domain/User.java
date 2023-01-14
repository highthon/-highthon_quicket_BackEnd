package com.example.dokgodieserver.domain.user.domain;

import com.example.dokgodieserver.domain.conversation.domain.ConversationUser;
import com.example.dokgodieserver.domain.user.domain.type.Authority;
import com.example.dokgodieserver.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    @NotNull
    private String accountId;

    @Column(length = 10)
    @NotNull
    private String name;

    @Column(length = 60)
    @NotNull
    private String password;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String profileImageUrl;

    @NotNull
    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @NotNull
    private int result;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ConversationUser> conversationUserList = new ArrayList<>();

    @Builder
    public User(String accountId, String name, String password, Authority authority, int result) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.result = result;
    }

    public void setResult(int result) {
        this.result += result;
    }

}
