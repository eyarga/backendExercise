package com.backend.exercise.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDto {

    private String title;

    private String contents;

    private long categoryId;
}
