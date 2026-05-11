package geekstore.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ProductoAgregado implements Question<Boolean> {

    public static ProductoAgregado alCarrito() {
        return new ProductoAgregado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        try {
            org.openqa.selenium.support.ui.WebDriverWait wait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
            wait.until(d -> !d.findElements(
                    org.openqa.selenium.By.xpath("//div[@class='jq-toast-single jq-has-icon jq-icon-success']")
            ).isEmpty());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}