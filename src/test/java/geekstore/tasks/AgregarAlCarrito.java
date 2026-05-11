package geekstore.tasks;

import geekstore.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarrito implements Task {

    private final String nombreCategoria;
    private final String nombreProducto;

    public AgregarAlCarrito(String nombreCategoria, String nombreProducto) {
        this.nombreCategoria = nombreCategoria;
        this.nombreProducto = nombreProducto;
    }

    public static AgregarAlCarrito conNombre(String categoria, String producto) {
        return instrumented(AgregarAlCarrito.class, categoria, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://testing.geekqa.net/public_html/public/index.php"),
                Scroll.to(CarritoPage.categoria(nombreCategoria)),
                WaitUntil.the(CarritoPage.categoria(nombreCategoria), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.categoria(nombreCategoria)),
                Scroll.to(CarritoPage.producto(nombreProducto)),
                WaitUntil.the(CarritoPage.producto(nombreProducto), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.producto(nombreProducto)),
                Scroll.to(CarritoPage.botonAgregarCarrito),
                WaitUntil.the(CarritoPage.botonAgregarCarrito, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(CarritoPage.botonAgregarCarrito)
        );
    }
}