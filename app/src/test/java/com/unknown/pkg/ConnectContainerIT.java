package com.unknown.pkg;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

/**
 * @author  jbellmann
 */
public class ConnectContainerIT {

    private final Logger logger = LoggerFactory.getLogger(ConnectContainerIT.class);

    @Test
    public void testDockerRun() throws InterruptedException {

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> entity = template.getForEntity("http://localhost:10080/print", String.class);
        logger.info("StatusCode: {}", entity.getStatusCode().toString());
        logger.info("Response: {}", entity.getBody());
    }
}
