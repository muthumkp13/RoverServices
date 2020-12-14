package com.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rover.RoverApplication;
import com.rover.contraoller.EnvironmentController;
import com.rover.output.response.CreateEnvironmentResponse;

/**
 * The Class EnvironmentControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RoverApplication.class)
@TestPropertySource(locations = {"classpath:application.yml"})
// @ActiveProfiles("dev")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnvironmentControllerTest {

  @Autowired
  EnvironmentController controller;

  /** The base url. */
  private String baseUrl = "/api/environment";

  protected MockMvc mvc;

  @Autowired
  WebApplicationContext context;
  /** The roverJson json. */
  public static JSONObject roverJson = null;
  protected static ObjectMapper mapper;
  protected static String dataPathRoverData = "src/test/resources/data/EnvironmentData.json";

  static {
    try {
      roverJson = new JSONObject(FileUtils.readFileToString(new File(dataPathRoverData), "UTF-8"));
      mapper = new ObjectMapper();
      mapper.findAndRegisterModules();
    } catch (Exception exception) {
    }
  }

  @Before
  public void setup() throws FileNotFoundException, IOException, JSONException {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testCreateEnvironmentSuccess() throws Exception {
    String url = baseUrl + "/configure";
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(url);
    request.content(roverJson.getJSONObject("createEnvironment").toString());

    MvcResult result = mvc.perform(request.contentType(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();
    String response = result.getResponse().getContentAsString();
    Assert.assertEquals("success", response);
  }
}
