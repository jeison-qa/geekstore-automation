package geekstore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static Target campoEmail = Target.the("campo email")
            .locatedBy("//input[@id='email']");

    public static Target campoClave = Target.the("campo clave")
            .locatedBy("//input[@id='password']");

    public static Target botonLogin = Target.the("boton login")
            .locatedBy("//button[contains(text(),'Login')]");

    public static Target mensajeError = Target.the("mensaje error")
            .locatedBy("//div[contains(@class,'alert-danger')]");

    public static Target miCuenta = Target.the("mi cuenta")
            .locatedBy("//a[contains(.,'My Account')]");
}