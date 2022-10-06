package com.sparta.api_test.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class TestRequestDto {

    private String title;
    private String writer;
    private String content;
    private String password;

    public TestRequestDto(String title, String writer, String content, String password) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }
}
