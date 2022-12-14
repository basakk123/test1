package com.example.hellomarket.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;
    @Column(name = "TIMESTAMP_FIELD")
    private java.sql.Timestamp timestampField;

    // FK가 만들어짐. user_id
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    // 조회를 위해서만 필요함
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comments> comments = new ArrayList<>();

    @Builder
    public Board(Long id, String title, String content, Timestamp timestampField, Users users,
            List<Comments> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestampField = timestampField;
        this.users = users;
        this.comments = comments;
    }

    // 변경하는 코드는 의미 있게 메서드로 구현 (세터처럼 불분명하게 X)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
