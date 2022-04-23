package com.codewater.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootHelloworldApplicationTests {

    @Test
    void contextLoads() {
    }

}
