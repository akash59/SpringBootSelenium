package com.udemy.spring.springselenium.propstest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseTestNGTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void propsTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("my.properties"));
        System.out.println(properties);
    }


}
