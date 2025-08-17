package de.kitchen_inventory_gras.java_backend.API;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class Items {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getItems() throws Exception {
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(content().json("[\"cheese\",\"milk\"]"));
    }

}
