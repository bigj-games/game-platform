package org.bigj.blackjack.web.controller;

import mockit.*;
import org.bigj.blackjack.config.BlackjackConfiguration;
import org.bigj.blackjack.config.BlackjackSecurityConfig;
import org.bigj.blackjack.config.BlackjackWebConfig;
import org.bigj.blackjack.service.GameService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by arthan on 27.10.2016. | Project game-platform
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                BlackjackConfiguration.class,
                BlackjackSecurityConfig.class,
                BlackjackWebConfig.class
        }
)
@WebAppConfiguration
public class GameControllerIT {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private GameService gameService;

    @BeforeClass
    public static void setUpMocksForSpringConfiguration() {
        new MockUp<GameService>() {
            @Mock String play(String command) {
                return "test_reply";
            }
        };
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_invoke_gameService_play_method() throws Exception {

        System.out.println(gameService.play("kkk"));

        new Expectations() {{ gameService.play("test_command"); }};

        mockMvc.perform(
                MockMvcRequestBuilders.post("/game/command")
                        .param("command", "test_command"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.response", CoreMatchers.is("test_reply")))
                .andExpect(status().isOk());
    }
}