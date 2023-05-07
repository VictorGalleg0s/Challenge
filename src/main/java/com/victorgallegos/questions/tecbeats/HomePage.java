package com.victorgallegos.questions.tecbeats;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static com.victorgallegos.userinterface.tecbeats.HomePage.HOME_PAGE;

public class HomePage implements Question<Boolean> {
    private final Target target;
    public HomePage(Target target) {
        this.target = target;
    }
    public static HomePage isOnHomePage() {
        return new HomePage(HOME_PAGE);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).waitUntilPresent().isVisible();
    }
}
