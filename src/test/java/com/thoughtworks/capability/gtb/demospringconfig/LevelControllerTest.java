package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {

    @Autowired
    private Environment env;
    @Autowired
    private MockMvc mockMvc;

// 命令行添加参数   java -jar build/libs/demo-spring-config-0.0.1-SNAPSHOT.jar --levelNumber=0
    @Test
    public void should_get_level() throws Exception {
        String str=env.getProperty("levelNumber");
        mockMvc.perform(get("/level"))
                .andExpect(status().isOk())
                .andExpect(content().string("advanced"));
    }
}