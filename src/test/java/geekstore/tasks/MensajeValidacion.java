package geekstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class MensajeValidacion implements Question<Boolean> {

    private final String mensaje;

    public MensajeValidacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static MensajeValidacion conTexto(String mensaje) {
        return new MensajeValidacion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        try {
            org.openqa.selenium.support.ui.WebDriverWait wait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
            wait.until(d -> !d.findElements(
                    org.openqa.selenium.By.xpath("//span[contains(.,'" + mensaje + "')]")
            ).isEmpty());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}