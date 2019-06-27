package org.spring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.spring.models.User;
import org.spring.services.ServicesUser;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


/**
 * Test.
 */
// SpringRunner is an alias of SpringJUnit4ClassRunner
// it's a Spring extension of JUnit that handles the TestContext
@RunWith(SpringRunner.class)

// we test only the SimpleController
@WebMvcTest(ControllerUser.class)
public class ControllerUserTest {

    // we inject the server side Spring MVC test support
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // we mock the service, here we test only the controller
    // @MockBean is a Spring annotation that depends on mockito framework
    @MockBean
    private ServicesUser ServicesUserMocked;

    private Response<User> response;

    private ResponseBody<User> responseBody;

    private User user;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        response = new Response<>();
        responseBody = new ResponseBody<>();
        List<User> listUsers;
        listUsers = new ArrayList<>();
        // Build list of users
        user = new User();
        user.setId("5421857");
        user.setPassword("pass123");
        user.setName("Isac");
        user.setLastName("Newton");
        user.setBirthDate("26/06/1996");
        user.setEmail("Isac.Newton@gmail.com");
        user.setType("admin");
        listUsers.add(user);
        responseBody.setData(listUsers);
    }

    /**
     * Test 1: Get.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test1() throws Exception {
        responseBody.setTextMessage(MessageManager.getSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);
        // Set the result of the mocked service
        BDDMockito.when(ServicesUserMocked.getAll()).thenReturn(response);

        // This is the JSON expected.
        String expectedBody = "{\"data\":[{\"" +
                "id\":\"5421857\",\"" +
                "password\":\"pass123\",\"" +
                "name\":\"Isac\",\"" +
                "lastName\":\"Newton\",\"" +
                "birthDate\":\"26/06/1996\",\"" +
                "email\":\"Isac.Newton@gmail.com\",\"" +
                "type\":\"admin\"}],\"" +
                "textMessage\":\"The get Users  successfully\"}";

        // Expect ResultMatcher object that was defined.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(jsonPath("$.id", "5421857"))
                .andExpect(MockMvcResultMatchers.content().string(expectedBody));
    }

    /**
     * Test 2: Get by Id.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test2() throws Exception {
        responseBody.setTextMessage(MessageManager.getSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);
        // Set the result of the mocked service
        BDDMockito.when(ServicesUserMocked.getById("5421857")).thenReturn(response);
        // This is the JSON expected.
        // Expect ResultMatcher object that was defined.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/users/5421857"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("5421857"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].password").value("pass123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Isac"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].lastName").value("Newton"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].birthDate")
                        .value("26/06/1996"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].email")
                        .value("Isac.Newton@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("admin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The get Users  successfully"));
    }

    /**
     * Test 3. Post.
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        // Build Response
        responseBody.setTextMessage(MessageManager.createdSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.CREATED)
                .setBody(responseBody);
        // we set the result of the mocked service
        //BDDMockito.given(ServicesUserMocked.add(user)).willReturn(response);
        BDDMockito.when(ServicesUserMocked.add(user)).thenReturn(response);

        // This is the JSON expected.
        String requestBody = "{" +
                "id\":\"5421857\",\"" +
                "password\":\"pass123\",\"" +
                "name\":\"Isac\",\"" +
                "lastName\":\"Newton\",\"" +
                "birthDate\":\"26/06/1996\",\"" +
                "email\":\"Isac.Newton@gmail.com\",\"" +
                "type\":\"admin\"},\"";
        // the test is executed:
        // perform: it executes the request and returns a ResultActions object
        // accept: type of media accepted as response
        // andExpect: ResultMatcher object that defines some expectations
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(this.user)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(requestBody));
    }
}
