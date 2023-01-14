package com.example.dokgodieserver.domain.grade.domain;

import com.example.dokgodieserver.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long target_id;

    @Builder
    public Grade(User user, Long target_id) {
        this.user = user;
        this.target_id = target_id;
    }

}
