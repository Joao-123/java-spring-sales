package org.spring.controllers;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


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

    // we mock the service, here we test only the controller
    // @MockBean is a Spring annotation that depends on mockito framework
    @MockBean
    private ServicesUser ServicesUserMocked;

    private Response<User> response;

    private ResponseBody<User> responseBody;

    private List<User> listUsers;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        response = new Response<>();
        responseBody = new ResponseBody<>();
        listUsers = new ArrayList<>();
    }

    /**
     * Test 1.
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        // Build Response
        User user = new User();
        user.setId("5421857");
        user.setPassword("pass123");
        user.setName("Isac");
        user.setLastName("Newton");
        user.setBirthDate("26/06/1996");
        user.setEmail("Isac.Newton@gmail.com");
        user.setType("admin");
        listUsers.add(user);
        responseBody.setData(listUsers);
        responseBody.setTextMessage(MessageManager.getSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);

        // we set the result of the mocked service
        //BDDMockito.given(ServicesUserMocked.add(user)).willReturn(new Response());
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

        // the test is executed:
        // perform: it executes the request and returns a ResultActions object
        // accept: type of media accepted as response
        // andExpect: ResultMatcher object that defines some expectations
        this.mockMvc
                .perform(get("/api/v1/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedBody));
    }

    /**
     * Test 1.
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        // Build Response
        User user = new User();
        user.setId("5421857");
        user.setPassword("pass123");
        user.setName("Isac");
        user.setLastName("Newton");
        user.setBirthDate("26/06/1996");
        user.setEmail("Isac.Newton@gmail.com");
        user.setType("admin");
        listUsers.add(user);
        responseBody.setData(listUsers);
        responseBody.setTextMessage(MessageManager.getSuccessfully("Users"));
        response
                .setHttpStatus(HttpStatus.OK)
                .setBody(responseBody);

        // we set the result of the mocked service
        //BDDMockito.given(ServicesUserMocked.add(user)).willReturn(new Response());
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

        // the test is executed:
        // perform: it executes the request and returns a ResultActions object
        // accept: type of media accepted as response
        // andExpect: ResultMatcher object that defines some expectations
        this.mockMvc
                .perform(get("/api/v1/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedBody));
    }
}
