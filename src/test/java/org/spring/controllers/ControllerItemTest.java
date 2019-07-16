package org.spring.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.spring.models.Item;
import org.spring.services.ServicesItem;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ControllerItem.class,secure = false)
public class ControllerItemTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicesItem servicesItem;

    private Response<Item> response;

    private ResponseBody<Item> responseBody;

    private Item mockItem;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        response = new Response<>();
        responseBody = new ResponseBody<>();

        // Build Items
        mockItem = new Item();
        mockItem.setId("1001");
        mockItem.setName("Coca cola");
        mockItem.setPrice("10");
        List<Item> listItems;
        listItems = new ArrayList<>();
        listItems.add(mockItem);
        responseBody.setData(listItems);

    }
    @Test
    public void testCreateTicket() throws Exception {

        // Build Response
        responseBody.setTextMessage(MessageManager.createdSuccessfully("Item"));
        response
                .setHttpStatus(HttpStatus.CREATED)
                .setBody(responseBody);


        String inputInJson = this.mapToJson(mockItem);
        Mockito.when(servicesItem.add(Mockito.any(Item.class))).thenReturn(response);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/items")
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        String expectedJsonResponse = this.mapToJson(responseBody);
        assertThat(outputInJson).isEqualTo(expectedJsonResponse);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
