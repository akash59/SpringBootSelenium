package com.udemy.spring.springselenium.visatest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.entity.User;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import com.udemy.spring.springselenium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.Date;


import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {


    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test
    public void visaTest() {
        List<User> users = this.userRepository
                .findAll()
                .stream()
                .limit(1)
                .collect(Collectors.toList());

        for(User u : users) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            logger.info("Request Confirmation # INFO :: "+this.registrationPage.getConfirmationNumber());
            logger.warn("Request Confirmation # WARN :: "+this.registrationPage.getConfirmationNumber());
            System.out.println(this.registrationPage.getConfirmationNumber());

        }
    }

    @Test
    public void visaTest2() {
        List<User> users = this.userRepository
                .findByFirstNameStartingWith("Mi")
                .stream()
                .limit(1)
                .collect(Collectors.toList());

        for(User u : users) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            logger.info("Request Confirmation # INFO :: "+this.registrationPage.getConfirmationNumber());
            logger.warn("Request Confirmation # WARN :: "+this.registrationPage.getConfirmationNumber());
            System.out.println(this.registrationPage.getConfirmationNumber());

        }
    }

    @Test(dataProvider = "getData")
    public void visaTest3(User u) {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        logger.info("Request Confirmation # INFO :: "+this.registrationPage.getConfirmationNumber());
        logger.warn("Request Confirmation # WARN :: "+this.registrationPage.getConfirmationNumber());
        System.out.println(this.registrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return this.userRepository
                .findByDobBetween(
                                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
                        )
                .stream()
                .limit(1)
                .toArray();
    }


}
