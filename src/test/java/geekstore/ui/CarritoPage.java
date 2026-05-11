package geekstore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {

    public static Target categoria(String nombre) {
        return Target.the("categoria " + nombre)
                .locatedBy("//div[@data-name='" + nombre + "']");
    }

    public static Target producto(String nombre) {
        return Target.the("producto " + nombre)
                .locatedBy("//h5[contains(text(),'" + nombre + "')]/ancestor::a");
    }

    public static Target botonAgregarCarrito = Target.the("boton agregar carrito")
            .locatedBy("//button[@id='addtocart-submit']");

    public static Target mensajeExito = Target.the("mensaje exito carrito")
            .locatedBy("//div[@class='jq-toast-single jq-has-icon jq-icon-success']");

    public static Target contadorCarrito = Target.the("contador carrito")
            .locatedBy("//small[@id='counter']");
}