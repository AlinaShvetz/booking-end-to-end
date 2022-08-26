package com.company.cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (features = {"test/resources/E2EBooking.feature"}, glue = {"com.company.Exp"})
public class bookingtestrunner {
}
