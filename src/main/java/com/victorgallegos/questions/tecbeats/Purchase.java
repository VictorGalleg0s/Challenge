package com.victorgallegos.questions.tecbeats;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static com.victorgallegos.userinterface.tecbeats.CheckoutCompletePage.*;

public class Purchase implements Question<String> {

    private final Target target;

    public Purchase(Target target) {
        this.target = target;
    }

    public static Purchase finishAlertText() {
        return new Purchase(PURCHASE_COMPLETE_TEXT_ALERT);
    }

    public static Purchase text() {
        return new Purchase(TEXT_PRODUCTS);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).waitUntilPresent().getText();
    }
}
