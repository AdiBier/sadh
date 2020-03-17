package com.ab.sadh.controller;

import com.ab.sadh.model.LoginCredentials;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:data.properties")
@AutoConfigureMockMvc
public class LoginControllerTest {

    private static final String PROPERTY_KEY_CORRECT_PASSWORD = "CORRECT_PASSWORD";

    private static final String PROPERTY_KEY_INCORRECT_PASSWORD = "INCORRECT_PASSWORD";

    private static final String PROPERTY_KEY_CORRECT_EMAIL = "CORRECT_EMAIL";

    private static final String PROPERTY_KEY_INCORRECT_EMAIL = "INCORRECT_EMAIL";

    private static final String PROPERTY_KEY_CORRECT_ROLE = "CORRECT_ROLE";

    private static final String LOGIN_URI = "/api/login";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Autowired
    private Environment environment;

    private String mapToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    private <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(json, clazz);
    }

    @Test
    public void testOfCorrectCredentials() throws JsonProcessingException, Exception {
        LoginCredentials correctCredentials = new LoginCredentials(environment.getProperty(PROPERTY_KEY_CORRECT_EMAIL), environment.getProperty(PROPERTY_KEY_CORRECT_PASSWORD));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post(LOGIN_URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(correctCredentials))).andReturn();

        String responseJson = result.getResponse().getContentAsString();

        Map<String, String> response = mapFromJson(responseJson, Map.class);
        assertEquals(200, result.getResponse().getStatus());

        assertEquals(environment.getProperty(PROPERTY_KEY_CORRECT_EMAIL), response.get("name")); //TODO probably delete
    }

    @Test
    public void testOfWrongLogin() throws JsonProcessingException, Exception {
        LoginCredentials wrongCredentials = new LoginCredentials(environment.getProperty(PROPERTY_KEY_INCORRECT_EMAIL), environment.getProperty(PROPERTY_KEY_CORRECT_PASSWORD));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post(LOGIN_URI)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(wrongCredentials))).andReturn();

        assertEquals(400, result.getResponse().getStatus());
    }
}