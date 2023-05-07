package com.victorgallegos.stepdefinitions.front;

import com.victorgallegos.questions.tecbeats.Common;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class CommonStepDefinitions {
    @Then("he/she/it should see error message: {string}")
    public void heShoulderrorMessage(String expectedText) {
        theActorInTheSpotlight().should(
                seeThat(Common.textError(), containsString(expectedText)));
    }
}
