package com.simran.insurancebackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloApi() {
        String response = restTemplate.getForObject("/hello", String.class);
        assertThat(response).isEqualTo("Hello Simran from cloned project!");
    }
}