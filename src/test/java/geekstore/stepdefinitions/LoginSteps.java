package geekstore.stepdefinitions;

import geekstore.questions.LoginExitoso;
import geekstore.tasks.Login;
import geekstore.tasks.MensajeValidacion;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {

    @Managed
    WebDriver driver;

    Actor usuario;

    @Before
    public void prepararActor() {
        usuario = Actor.named("Usuario GeekStore");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario abre la pagina de login de GeekStore")
    public void abrirLogin() {
        usuario.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php/SignUp")
        );
    }

    @When("ingresa email {string} y clave {string}")
    public void ingresarCredenciales(String email, String clave) {
        usuario.attemptsTo(
                Login.conCredenciales(email, clave)
        );
    }

    @Then("el resultado del login es {string}")
    public void verificarResultado(String resultado) {
        if (resultado.equals("debe ver su cuenta activa")) {
            usuario.should(seeThat(LoginExitoso.enLaPagina(), equalTo(true)));
        } else {
            usuario.should(seeThat(MensajeValidacion.conTexto(resultado), equalTo(true)));
        }
    }
    }



