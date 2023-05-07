package com.victorgallegos.userinterface.tecbeats;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompletePage {

    public static final Target PURCHASE_COMPLETE_TEXT_ALERT =
            Target.the("Purchase complete text alert").located(By.className("complete-text"));


 public static final Target TEXT_PRODUCTS =
            Target.the("Text products").located(By.xpath("//span[text()='Products']"));

    private CheckoutCompletePage() {
        super();
    }
}
