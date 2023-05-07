package com.victorgallegos.stepdefinitions.front;

import io.cucumber.java.en.Then;

import static com.victorgallegos.questions.tecbeats.HomePage.isOnHomePage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HomePageStepDefinitions {

    @Then("he/she/it should see the home page")
    public void heShouldSeeHomePage() {
        theActorInTheSpotlight().should(
                seeThat(isOnHomePage()));
    }
}
