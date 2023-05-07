package com.victorgallegos.userinterface.tecbeats;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target HOME_PAGE =
            Target.the("Home page").located(By.id("page_wrapper"));
}
