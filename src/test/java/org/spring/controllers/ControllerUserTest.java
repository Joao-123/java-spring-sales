package org.spring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;


/**
 * Test.
 */
// SpringRunner is an alias of SpringJUnit4ClassRunner
// it's a Spring extension of JUnit that handles the TestContext
@RunWith(SpringRunner.class)
// Test only the SimpleController
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
        //BDDMockito.given(ServicesUserMocked.add(user)).willReturn(response);
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
     * @throws Exception Exception.
     */
    @Test
    public void test3() throws Exception {
        //ControllerUser controllerUser = new ControllerUser();
        // this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUser).build();

        // Build Response
        responseBody.setTextMessage(MessageManager.createdSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.CREATED)
                .setBody(responseBody);
        BDDMockito.when(ServicesUserMocked.add(this.user)).thenReturn(response);

        //ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        //ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //String requestBodyJson = ow.writeValueAsString(this.user);

        String contentBody = "{ \"id\": \"5814525\", \"password\": \"pass123\", \"name\": \"Sheldon\", \"lastName\": \"Cooper\", \"birthDate\": \"11/10/1999\", \"email\": \"Sheldon.Cooper@gmail.com\", \"type\": \"admin\" }";
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(contentBody));

                /* .param("id", "1587654")
                 .param("password", "myPassword123")
                 .param("name", "Michael")
                 .param("lastName", "Suarez")
                 .param("birthDate", "25/03/1998")
                 .param("email", "Michael.Suarez@gmail.com")
                 .param("type", "admin")*/
/*
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The get Users  successfully"));*/
    }

    /**
     * Test 4: Put.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test4() throws Exception {
        responseBody.setTextMessage(MessageManager.updatedSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);
        // Build Body Request
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestBodyJson = ow.writeValueAsString(this.user);
        // Set the result of the mocked service
        BDDMockito.when(ServicesUserMocked.update(this.user, "5421857")).thenReturn(response);

        // This is the JSON expected.
        // Expect ResultMatcher object that was defined.
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/v1/users/5421857")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestBodyJson))
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
     * Test 5: Delete.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test5() throws Exception {
        responseBody.setTextMessage(MessageManager.deletedSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);
        // Set the result of the mocked service
        BDDMockito.when(ServicesUserMocked.delete("5421857")).thenReturn(response);
        // This is the JSON expected.
        // Expect ResultMatcher object that was defined.
        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/v1/users/5421857"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The Users was deleted successfully"));
    }
}
