package guru.springframework.beanscope.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.implementation.MethodDelegation.to;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashSet;

@WebMvcTest
class RequestScopeControllerTest {

    @Autowired
    private RequestScopeController requestScopeController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(requestScopeController)
                .build();
    }

    @Test
    void getMessage() throws Exception {
        MockHttpServletResponse response1 = mockMvc.perform(get("/message"))
                .andReturn().getResponse();
        MockHttpServletResponse response2 = mockMvc.perform(get("/message"))
                .andReturn().getResponse();
        assertThat(response1.equals(to(response2)));


    }
}