package com.udemy.spring.springselenium.flighttest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlightTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails flightAppDetails;

    @BeforeMethod
    public void launchApp() {
        this.flightPage.goTo(this.flightAppDetails.getUrl());
    }

    @Test
    public void flightTest() {
        Assert.assertTrue(this.flightPage.isLoaded());
        System.out.println("Actual Labels :: "+this.flightPage.getLabels());
        Assert.assertEquals(this.flightPage.getLabels(), this.flightAppDetails.getLabels());
    }

    @AfterMethod
    public void closePage() {
        this.flightPage.close();
    }
}
