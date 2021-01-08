package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Testing {@link ru.job4j.forum.controllers.TopicControl}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TopicControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenCallTopicCreateShouldReturnTopicEditPage() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void whenCallTopicEditShouldReturnTopicEditPage() throws Exception {
        this.mockMvc.perform(get("/edit/13"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void whenOpenTopicShouldReturnTopicViewPage() throws Exception {
        this.mockMvc.perform(get("/13"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic"));
    }
}
