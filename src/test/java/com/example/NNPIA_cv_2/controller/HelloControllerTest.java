package com.example.NNPIA_cv_2.controller;

import com.example.NNPIA_cv_2.NnpiaCv2Application;
import com.example.NNPIA_cv_2.entity.AppUser;
import com.example.NNPIA_cv_2.repository.AppUserRepository;
import com.example.NNPIA_cv_2.security.TestSecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
@Import(HelloController.class)
//@SpringBootTest(classes = TestSecurityConfig.class)
@WithMockUser(username = "user", password = "password")
class HelloControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AppUserRepository mockAppUserRepository;

    @MockBean
    JwtDecoder jwtDecoder;

    @Test
    void appUsers() {
    }

    @Test
    void insertAppUser() {
    }

    @Test
    void updateAppUser() {
    }

    @Test
    void deleteAppUser() {
    }

    @Test
    void getUserById() throws Exception {
        //AppUser mockUser = mock(AppUser.class);
        int userId = 100;
        String userName = "Testovaci uzivatel";
        AppUser mockUser = new AppUser();
        mockUser.setId(userId);
        mockUser.setUsername(userName);

        given(mockAppUserRepository.findById(userId)).willReturn(Optional.of(mockUser));

        mockMvc.perform(get("/app-user?userId=" + userId).with(jwt().authorities(new SimpleGrantedAuthority("booking:WRITE"))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(mockUser.getId())))
                .andExpect(jsonPath("$.username", is(mockUser.getUsername())))
        ;

    }

    @Test
    void getUsersByRole() {
    }
}