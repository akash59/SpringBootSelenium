package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google.GooglePage;
import com.udemy.spring.springselenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
        Assert.assertTrue(this.googlePage.getSearchResult().getResultsCount() > 2);
        screenshotService.takeScreenshot("selenium_"+ Math.random() +"_.png");
        this.googlePage.close();
    }

}
