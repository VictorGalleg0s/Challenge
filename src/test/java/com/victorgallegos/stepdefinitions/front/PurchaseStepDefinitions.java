package com.victorgallegos.stepdefinitions.front;
import com.victorgallegos.interactions.front.tecbeats.AddToCart;
import com.victorgallegos.interactions.front.tecbeats.CompleteCheckoutInformation;
import com.victorgallegos.interactions.front.tecbeats.Signin;

import static com.victorgallegos.questions.tecbeats.HomePage.isOnHomePage;
import static com.victorgallegos.userinterface.tecbeats.HomePage.HOME_PAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

import com.victorgallegos.questions.tecbeats.Common;
import com.victorgallegos.questions.tecbeats.HomePage;
import com.victorgallegos.questions.tecbeats.Purchase;
import com.victorgallegos.userinterface.tecbeats.CheckoutCompletePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.util.EnvironmentVariables;



import java.util.Map;

import static com.victorgallegos.utils.enums.EnumConstants.BASE_URL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class PurchaseStepDefinitions {

    private static final String USER = "The user";
    private static final String FIRSTNAME = "Firstname";
    private static final String LASTNAME = "Lastname";
    private static final String ZIPCODE = "ZipCode";
    private EnvironmentVariables environmentVariables;

    @Given("the user is on the login page")
    public void userOnLoginPage() {
        theActorCalled(USER).wasAbleTo(Open.url(
                EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty(BASE_URL.getConstantValue())
        ));
    }

    @And("he/she/it signs in with the following credentials: {string}, {string}")
    public void heSignsInWithTheFollowingCredentials(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Signin.withTheUser(username, password));
    }

    @When("he adds to the cart a random item from the product page")
    public void heAddsToTheCartARandomItemFromTheProductPage() {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.aRandomItem().andGoToCheckout());
    }

    @And("completes the checkout form with the data")
    public void completesTheCheckoutFormWithTheData(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutInformation
                        .withTheData(formData.get(FIRSTNAME), formData.get(LASTNAME), formData.get(ZIPCODE))
                        .andFinishThePurchase());
    }

    @Then("he/she/it should see on the purchase congrats page the following text: {string}")
    public void heShouldSeeOnThePurchaseCongratsPageTheFollowingText(String expectedText) {
        theActorInTheSpotlight().should(
                seeThat(Purchase.finishAlertText(), containsString(expectedText)));
    }



    @Then("he/she/it should see text: {string}")
    public void heShouldSeeText(String expectedText) {
        theActorInTheSpotlight().should(
                seeThat(Purchase.text(), containsString(expectedText)));
    }




}
