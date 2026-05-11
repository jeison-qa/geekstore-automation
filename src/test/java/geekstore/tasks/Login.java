package geekstore.tasks;

import geekstore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String email;
    private final String clave;

    public Login(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public static Login conCredenciales(String email, String clave) {
        return instrumented(Login.class, email, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.campoEmail, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(LoginPage.campoEmail),
                Enter.theValue(clave).into(LoginPage.campoClave),
                Click.on(LoginPage.botonLogin)
        );
    }
}