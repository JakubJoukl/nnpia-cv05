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

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    void insertAppUser() throws Exception {
        AppUser newUser = new AppUser();
        newUser.setId(500);
        newUser.setUsername("Insertovany");
        newUser.setPassword("Heslo");
        newUser.setActive(true);
        newUser.setCreationDate(Date.valueOf("2024-03-20"));

        given(mockAppUserRepository.existsById(500)).willReturn(false);
        given(mockAppUserRepository.save(newUser)).willReturn(newUser);

        mockMvc.perform(post("/insertAppUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newUser))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

        mockMvc.perform(get("/app-user?userId=" + userId))
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