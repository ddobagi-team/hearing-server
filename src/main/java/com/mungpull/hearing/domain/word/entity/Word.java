package com.mungpull.hearing.domain.word.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_word")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String korean;
    @Column
    private String mouth;
    @Column
    private String hand;
    @Column
    private int type;

    @Builder
    public Word(String korean, String mouth, String hand, int type) {
        this.korean = korean;
        this.mouth = mouth;
        this.hand = hand;
        this.type = type;
    }
}
