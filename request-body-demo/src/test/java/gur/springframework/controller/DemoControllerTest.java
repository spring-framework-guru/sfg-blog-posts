package gur.springframework.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import gur.springframework.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DemoControllerTest {

  private  MockMvc mockMvc;
  private User user;

    @BeforeEach
    void setUp() {
        user = new User("John","pass1234");

         mockMvc = MockMvcBuilders
                .standaloneSetup(DemoController.class)
                .build();
    }

@Test
    void registerUserCredential()throws Exception {

    MvcResult result =    mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(asJsonString(user)))
            .andExpect(status().isCreated())
            .andReturn();
    String content = result.getResponse().getContentAsString();
    System.out.println(content);

}
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}