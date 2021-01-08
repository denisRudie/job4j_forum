package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.models.Message;
import ru.job4j.forum.models.Topic;
import ru.job4j.forum.services.TopicService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @MockBean
    private TopicService service;

    /**
     * Service should open topic creating page.
     */
    @Test
    @WithMockUser
    public void whenCallTopicCreateShouldReturnTopicEditPage() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    /**
     * Service should open topic editing page.
     */
    @Test
    @WithMockUser
    public void whenCallTopicEditShouldReturnTopicEditPage() throws Exception {
                this.mockMvc.perform(get("/edit/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    /**
     * Service should open topic page.
     */
    @Test
    @WithMockUser
    public void whenOpenTopicShouldReturnTopicViewPage() throws Exception {
        Topic t = new Topic();
        when(service.getTopicById(anyInt())).thenReturn(t);

        this.mockMvc.perform(get("/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic"));
    }

    /**
     * Service should create topic.
     */
    @Test
    @WithMockUser
    public void whenCreateTopicThenReturnTopicName() throws Exception {
        this.mockMvc.perform(post("/save")
                .param("name", "Куплю ладу-грант. Дорого.")
                .param("username", "user"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        ArgumentCaptor<Topic> topicArg = ArgumentCaptor.forClass(Topic.class);
        ArgumentCaptor<Message> messageArg = ArgumentCaptor.forClass(Message.class);
        verify(service).saveTopic(topicArg.capture(), any(), messageArg.capture());

        assertEquals("Куплю ладу-грант. Дорого.", topicArg.getValue().getName());
    }

    /**
     * Service should update topic.
     */
    @Test
    @WithMockUser
    public void serviceShouldUpdateTopic() throws Exception {
        Topic t = new Topic();
        when(service.getTopicById(anyInt())).thenReturn(t);

        this.mockMvc.perform(post("/save")
                .param("id", "1")
                .param("name", "after update")
                .param("username", "user"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        ArgumentCaptor<Topic> topicArg = ArgumentCaptor.forClass(Topic.class);
        ArgumentCaptor<Message> messageArg = ArgumentCaptor.forClass(Message.class);
        verify(service).saveTopic(topicArg.capture(), any(), messageArg.capture());

        assertEquals(1, topicArg.getValue().getId());
        assertEquals("after update", topicArg.getValue().getName());
    }

    /**
     * Service should add new messages to existing topic.
     */
    @Test
    @WithMockUser
    public void serviceShouldCreateMessages() throws Exception {
        Topic t = new Topic();
        when(service.getTopicById(eq(1))).thenReturn(t);

        this.mockMvc.perform(post("/create_message")
                .param("text", "message")
                .param("topicId", "1")
                .param("username", "user"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        ArgumentCaptor<Message> messageArg = ArgumentCaptor.forClass(Message.class);
        verify(service).addMessage(messageArg.capture(), anyInt(), anyString());

        assertEquals("message", messageArg.getValue().getText());
    }
}
