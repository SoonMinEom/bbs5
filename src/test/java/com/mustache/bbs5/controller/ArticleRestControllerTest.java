package com.mustache.bbs5.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.bbs5.domain.dto.ArticleAddRequest;
import com.mustache.bbs5.domain.dto.ArticleAddResponse;
import com.mustache.bbs5.domain.dto.ArticleResponse;
import com.mustache.bbs5.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("하나의 Article 을 Json 형태로 잘 가지고 오는지")
    void getArticle() throws Exception {
        ArticleResponse articleResponse = ArticleResponse.builder()
                .id(1L)
                .title("gdgd333")
                .content("gdgd333")
                .build();

        given(articleService.getArticle(1L)).willReturn(articleResponse);

        Long articleId = 1L;
        String url = String.format("/api/v1/articles/%d",articleId);

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("gdgd333"))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").value("gdgd333"))
                .andDo(print());

        verify(articleService).getArticle(1L);
    }


    @Test
    @DisplayName("잘 추가")
    void add() throws Exception {

        ArticleAddRequest dto = new ArticleAddRequest("제목입니다","내용입니다.");
        ArticleAddResponse articleAddResponse = new ArticleAddResponse(1L,"제목입니다.","내용입니다.");

        given(articleService.add(dto)).willReturn(articleAddResponse);

        mockMvc.perform(post("/api/v1/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목입니당"))
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).add(dto);
    }
}