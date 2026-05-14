package geekstore.stepdefinitions;

import geekstore.questions.ComputadorConfigurado;
import geekstore.tasks.ConfigurarComputador;
import geekstore.tasks.Login;
import geekstore.ui.CarritoPage;
import geekstore.ui.ComputadorPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class ComputadorSteps {

    @Managed
    WebDriver driver;

    Actor usuario;

    @Before
    public void prepararActor() {
        usuario = Actor.named("Usuario GeekStore Computador");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario esta autenticado y selecciona la categoria {string}")
    public void seleccionarCategoria(String categoria) {
        usuario.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php/SignUp")
        );
        Login.conCredenciales(
                System.getenv("GEEKSTORE_USER") != null ? System.getenv("GEEKSTORE_USER") : "testuser1@yopmail.com",
                System.getenv("GEEKSTORE_PASS") != null ? System.getenv("GEEKSTORE_PASS") : "Test1234!"
        );
        usuario.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php"),
                Scroll.to(CarritoPage.categoria(categoria)),
                WaitUntil.the(CarritoPage.categoria(categoria), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.categoria(categoria)),
                Scroll.to(ComputadorPage.botonBuildComputer),
                WaitUntil.the(ComputadorPage.botonBuildComputer, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ComputadorPage.botonBuildComputer)
        );
    }
    @When("configura el computador con processor {string} os {string} ssd {string} y ram {string}")
    public void ConfigurarComputador(String processor, String os, String ssd, String ram) {
        usuario.attemptsTo(
                ConfigurarComputador.con(processor, os, ssd, ram)
        );
    }


    @Then("el resultado de la configuracion es {string}")
    public void verificarResultado(String resultado) {
        if (resultado.equals("boton agregar visible")) {
            usuario.should(seeThat(ComputadorConfigurado.botonVisible(), equalTo(true)));
        } else {
            usuario.should(seeThat(ComputadorConfigurado.conErrorRam(), equalTo(true)));
        }
    }
}