package com.fastcampus.adminproject.controller;

import com.fastcampus.adminproject.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 어드민 회원")
@Import(SecurityConfig.class)
@WebMvcTest(AdminUserAccountControllerTest.class)
class AdminUserAccountControllerTest {

    private MockMvc mvc;

    public AdminUserAccountControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 어드민 회원 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingAdminMembersView_thenReturnsAdminMembersView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/admin/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("/admin/members"));
    }

}