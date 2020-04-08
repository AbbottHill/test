package com.cd.test.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChuD
 * @date 2020-04-08 10:47
 */
public class Slf4jTest {

    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
        logger.error(" \n[{}] \n[{}] \n[{}] \n","123", "1234", "12345");
    }
}
