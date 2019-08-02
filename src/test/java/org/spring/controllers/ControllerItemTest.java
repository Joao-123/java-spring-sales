
package org.spring.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.spring.models.Item;
import org.spring.services.ServicesItem;
import org.spring.responses.ResponseMessage;
import org.spring.responses.Response;
import org.spring.responses.ResponseBody;
import org.spring.support.TestSupport;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


/**
 * Test.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ControllerItem.class, secure = false)
public class ControllerItemTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicesItem servicesItemMocked;

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
        // Build list of items and responses body.
        mockItem = new Item();
        final Integer id = 1001;
        mockItem.setId(id);
        mockItem.setName("Coca cola");
        final Double price = 10.0;
        mockItem.setPrice(price);
        final Integer stock = 10;
        mockItem.setStock(stock);
        List<Item> listItems;
        listItems = new ArrayList<>();
        listItems.add(mockItem);
        responseBody.setData(listItems);
    }

    /**
     * Test1. Get.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test1() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.getSuccessfully("Items"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        Mockito.when(servicesItemMocked.getAll()).thenReturn(response);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/items"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("1001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Coca cola"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].price").value("10.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].stock").value("10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The get Items successfully"));
    }

    /**
     * Test2. Get by id.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test2() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.getSuccessfully("Item"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        Mockito.when(servicesItemMocked.getById(Mockito.any(Integer.class))).thenReturn(response);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/items/1001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("1001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Coca cola"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].price").value("10.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].stock").value("10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The get Item successfully"));
    }

    /**
     * Test3. Post.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test3() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.createdSuccessfully("Item"));
        response.setHttpStatus(HttpStatus.CREATED).setBody(responseBody);
        // Mock Services
        String inputInJson = TestSupport.getInstance().mapToJson(mockItem);
        Mockito.when(servicesItemMocked.add(Mockito.any(Item.class))).thenReturn(response);
        // Request
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/items")
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        // Catch Result.
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        // Asserts
        MockHttpServletResponse response = result.getResponse();
        String actualJsonResponse = response.getContentAsString();
        String expectedJsonResponse = TestSupport.getInstance().mapToJson(responseBody);
        assertThat(actualJsonResponse).isEqualTo(expectedJsonResponse);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test4 post.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test4() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.createdSuccessfully("Item"));
        response.setHttpStatus(HttpStatus.CREATED).setBody(responseBody);
        // Mock Services
        String inputInJson = TestSupport.getInstance().mapToJson(mockItem);
        Mockito.when(servicesItemMocked.add(Mockito.any(Item.class))).thenReturn(response);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/items")
                        .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("1001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Coca cola"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].price").value("10.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].stock").value("10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The Item was created successfully"));
    }

}
