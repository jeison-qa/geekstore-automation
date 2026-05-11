package geekstore.stepdefinitions;

import geekstore.questions.ProductoAgregado;
import geekstore.tasks.AgregarAlCarrito;
import geekstore.tasks.Login;
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

public class CarritoSteps {

    @Managed
    WebDriver driver;

    Actor usuario;

    @Before
    public void prepararActor() {
        usuario = Actor.named("Usuario GeekStore Carrito");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario esta autenticado en GeekStore")
    public void autenticarUsuario() {
        usuario.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php/SignUp")
        );
        usuario.attemptsTo(
                Login.conCredenciales("testuser1@yopmail.com", "Test1234!")
        );
    }

    @When("selecciona la categoria {string} y agrega el producto {string} al carrito")
    public void agregarProducto(String categoria, String producto) {
        usuario.attemptsTo(
                AgregarAlCarrito.conNombre(categoria, producto)
        );
    }

    @Then("debe ver el mensaje de producto agregado")
    public void verificarProductoAgregado() {
        usuario.should(
                seeThat(ProductoAgregado.alCarrito(), equalTo(true))
        );
    }
}