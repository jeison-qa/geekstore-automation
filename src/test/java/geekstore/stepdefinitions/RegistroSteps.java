package geekstore.stepdefinitions;
import geekstore.questions.RegistroExitoso;
import geekstore.tasks.MensajeValidacion;
import geekstore.tasks.Registro;
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

public class RegistroSteps {

    @Managed
    WebDriver driver;

    Actor usuario;

    @Before
    public void prepararActor() {
        usuario = Actor.named("Usuario GeekStore");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario abre la pagina de registro de GeekStore")
    public void abrirRegistro() {
        usuario.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php/SignUp")
        );
    }

    @When("completa el formulario con {string} {string} {string} {string} {string} y {string}")
    public void completarFormulario(String telefono, String email, String usuario, String nombre, String apellido, String clave) {
        if (email.equals("RANDOM") || usuario.equals("RANDOM")) {
            this.usuario.attemptsTo(
                    Registro.conDatosAleatorios()
            );
        } else {
            this.usuario.attemptsTo(
                    Registro.conDatos(telefono, email, usuario, nombre, apellido, clave)
            );
        }

    }

    @Then("{string}")
    public void verificarResultado(String resultado) {
        if (resultado.equals("debe ver el dashboard con su cuenta activa")) {
            usuario.should(seeThat(RegistroExitoso.enLaPagina(), equalTo(true)));
        } else {
            usuario.should(seeThat(MensajeValidacion.conTexto(resultado), equalTo(true)));
        }
    }
}
