package guru.springframework.beanscope.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.implementation.MethodDelegation.to;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class SessionScopeControllerTest {
    @Autowired
    private SessionScopeController sessionScopeController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(sessionScopeController)
                .build();
    }

    @Test
    void getMessage() throws Exception {
        MockHttpSession session1 = new MockHttpSession();
        MockHttpSession session2 = new MockHttpSession();
        MockHttpServletResponse response1 = mockMvc.perform(get("/session/message").session(session1))
                .andReturn().getResponse();
        MockHttpServletResponse response2 = mockMvc.perform(get("/session/message").session(session1))
                .andReturn().getResponse();
        assertThat(response1.equals(to(response2)));
        MockHttpServletResponse response3 = mockMvc.perform(get("/session/message").session(session2))
                .andReturn().getResponse();
        assertThat(response3).isNotEqualTo(response1);
        assertThat(response3).isNotEqualTo(response2);

    }
}