package com.victorgallegos.runners.front;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/examples/front/",
        glue = {"com/victorgallegos/stepdefinitions"},
        tags = "@Smoke")
public class PurchaseRunner {
}
