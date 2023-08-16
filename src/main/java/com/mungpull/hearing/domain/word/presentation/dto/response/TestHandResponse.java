package com.mungpull.hearing.domain.word.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TestHandResponse {
    private String answer;
    private List<String> wrong;
}
