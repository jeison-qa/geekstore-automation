package geekstore.tasks;

import geekstore.ui.RegistroPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Registro implements Task {

    private final String telefono;
    private final String email;
    private final String usuario;
    private final String nombre;
    private final String apellido;
    private final String clave;

    public Registro(String telefono, String email, String usuario, String nombre, String apellido, String clave) {
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public static Registro conDatos(String telefono, String email, String usuario, String nombre, String apellido, String clave) {
        return instrumented(Registro.class, telefono, email, usuario, nombre, apellido, clave);
    }

    public static Registro conDatosAleatorios() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "user" + timestamp + "@yopmail.com";
        String usuario = "user" + timestamp;
        return instrumented(Registro.class, "3001234567", email, usuario, "Juan", "Perez", "Test1234!");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistroPagina.campoTelefono, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(telefono).into(RegistroPagina.campoTelefono),
                Enter.theValue(email).into(RegistroPagina.campoEmail),
                Enter.theValue(usuario).into(RegistroPagina.campoUsuario),
                Enter.theValue(nombre).into(RegistroPagina.campoNombre),
                Enter.theValue(apellido).into(RegistroPagina.campoApellido),
                Enter.theValue(clave).into(RegistroPagina.campoClave),
                Enter.theValue(clave).into(RegistroPagina.campoConfirmarClave),
                Scroll.to(RegistroPagina.botonSignUp),
                Click.on(RegistroPagina.botonSignUp)
        );
    }
}