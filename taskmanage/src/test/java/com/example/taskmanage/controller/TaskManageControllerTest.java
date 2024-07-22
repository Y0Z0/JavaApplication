package com.example.taskmanage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.not;



@SpringBootTest
@AutoConfigureMockMvc
class TaskManageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void greeting() {
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                .andExpect(content().string(containsString("task1")))
                .andExpect(content().string(containsString("task2")));
    }

    @Test
    public void testInsert() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                .andExpect(content().string(containsString("タスク追加")))
                .andExpect(content().string(not(containsString("タスク追加タスク追加"))));
    }
}