package com.victorgallegos.userinterface.tecbeats;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonPage {

    public static final Target TEXT_ERROR=
            Target.the("Text error").located(By.xpath("//div[contains(@class, 'error-message-container')]/h3"));

}
