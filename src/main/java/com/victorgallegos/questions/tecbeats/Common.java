package com.victorgallegos.questions.tecbeats;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static com.victorgallegos.userinterface.tecbeats.CommonPage.TEXT_ERROR;

public class Common implements Question<String>  {
        private final Target target;

        public Common(Target target) {
            this.target = target;
        }

        public static Common textError() {
            return new Common(TEXT_ERROR);
        }

        @Override
        public String answeredBy(Actor actor) {
            return target.resolveFor(actor).waitUntilPresent().getText();
        }

}
