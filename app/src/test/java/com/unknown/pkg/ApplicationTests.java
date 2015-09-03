package com.unknown.pkg;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import org.springframework.http.ResponseEntity;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.client.RestTemplate;

import de.sigmalab.siggi.example.ExampleApplication;

/**
 * @author  jbellmann
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ExampleApplication.class})
@WebIntegrationTest(randomPort = true)
@ActiveProfiles("local")
public class ApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Value("${local.server.port}")
    int port;

    @Test
    public void test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        logger.info("PORT IS : {}", port);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> entity = template.getForEntity("http://localhost:" + port + "/print", String.class);
        logger.info("StatusCode: {}", entity.getStatusCode().toString());
        logger.info("Response: {}", entity.getBody());
    }
}
