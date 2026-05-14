package geekstore.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ComputadorConfigurado implements Question<Boolean> {

    private final String tipo;

    public ComputadorConfigurado(String tipo) {
        this.tipo = tipo;
    }

    public static ComputadorConfigurado botonVisible() {
        return new ComputadorConfigurado("boton");
    }

    public static ComputadorConfigurado conErrorRam() {
        return new ComputadorConfigurado("error");
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        try {
            org.openqa.selenium.support.ui.WebDriverWait wait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            if (tipo.equals("boton")) {
                wait.until(d -> !d.findElements(
                        org.openqa.selenium.By.xpath("//button[@id='addtocart-submit']")
                ).isEmpty());
            } else {
                wait.until(d -> !d.findElements(
                        org.openqa.selenium.By.xpath("//p[@id='invalid-ram']")
                ).isEmpty());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}