package org.spring.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.spring.models.User;
import org.spring.responses.Response;
import org.spring.responses.ResponseBody;
import org.spring.responses.ResponseMessage;
import org.spring.services.ServicesUser;
import org.spring.support.TestSupport;
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
// SpringRunner is an alias of SpringJUnit4ClassRunner.
// It's a Spring extension of JUnit that handles the TestContext
@RunWith(SpringRunner.class)
// Test only the SimpleController
@WebMvcTest(ControllerUser.class)
public class ControllerUserTest {

    // Inject the server side Spring MVC test support
    @Autowired
    private MockMvc mockMvc;

    // Mock the service, here we test only the controller.
    // @MockBean is a Spring annotation that depends on mockito framework
    @MockBean
    private ServicesUser servicesUserMocked;

    private Response<User> response;

    private ResponseBody<User> responseBody;

    private User mockUser;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        response = new Response<>();
        responseBody = new ResponseBody<>();
        List<User> listUsers;
        listUsers = new ArrayList<>();
        // Build list of users and response body.
        mockUser = new User();
        mockUser.setId("5421857");
        mockUser.setPassword("pass123");
        mockUser.setName("Isac");
        mockUser.setLastName("Newton");
        mockUser.setBirthDate("1996-06-26");
        mockUser.setEmail("Isac.Newton@gmail.com");
        mockUser.setType("admin");
        listUsers.add(mockUser);
        responseBody.setData(listUsers);
    }


    /**
     * Test 1: Get.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test1() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.getSuccessfully("Users"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        BDDMockito.when(servicesUserMocked.getAll()).thenReturn(response);
        // This is the JSON expected.
        String expectedBody = "{\"data\":[{\""
                + "id\":\"5421857\",\""
                + "password\":\"pass123\",\""
                + "name\":\"Isac\",\""
                + "lastName\":\"Newton\",\""
                + "birthDate\":\"1996-06-26\",\""
                + "email\":\"Isac.Newton@gmail.com\",\""
                + "type\":\"admin\"}],\""
                + "textMessage\":\"The get Users successfully\"}";
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedBody));
    }

    /**
     * Test 2: Get by Id.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test2() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.getSuccessfully("Users"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        BDDMockito.when(servicesUserMocked.getById("5421857")).thenReturn(response);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/users/5421857"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("5421857"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].password").value("pass123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Isac"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].lastName").value("Newton"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].birthDate")
                        .value("1996-06-26"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].email")
                        .value("Isac.Newton@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("admin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The get Users successfully"));
    }

    /**
     * Test 3. Post.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test3() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.createdSuccessfully("User"));
        response.setHttpStatus(HttpStatus.CREATED).setBody(responseBody);
        // Mock Services
        Mockito.when(servicesUserMocked.add(Mockito.any(User.class))).thenReturn(response);
        String bodyRequest = TestSupport.getInstance().mapToJson(mockUser);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .accept(MediaType.APPLICATION_JSON).content(bodyRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("5421857"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].password").value("pass123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Isac"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].lastName").value("Newton"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].birthDate")
                        .value("1996-06-26"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].email")
                        .value("Isac.Newton@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("admin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The User was created successfully"));
    }

    /**
     * Test 4: Put.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test4() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.updatedSuccessfully("User"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        Mockito.when(servicesUserMocked.update(Mockito.any(User.class),
                Mockito.any(String.class))).thenReturn(response);
        String bodyRequest = TestSupport.getInstance().mapToJson(mockUser);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/v1/users/5421857")
                        .accept(MediaType.APPLICATION_JSON).content(bodyRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value("5421857"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].password").value("pass123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("Isac"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].lastName").value("Newton"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].birthDate")
                        .value("1996-06-26"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].email")
                        .value("Isac.Newton@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("admin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The User was updated successfully"));
    }

    /**
     * Test 5: Delete.
     *
     * @throws Exception Exception.
     */
    @Test
    public void test5() throws Exception {
        // Build Response
        responseBody.setTextMessage(ResponseMessage.deletedSuccessfully("Users"));
        response.setHttpStatus(HttpStatus.OK).setBody(responseBody);
        // Mock Services
        BDDMockito.when(servicesUserMocked.delete("5421857")).thenReturn(response);
        // Request and Asserts.
        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/v1/users/5421857"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.textMessage")
                        .value("The Users was deleted successfully"));
    }
}
