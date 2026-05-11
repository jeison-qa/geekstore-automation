package geekstore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegistroPagina {

    public static Target campoTelefono = Target.the("campo telefono")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='phone_number']");

    public static Target campoEmail = Target.the("campo email")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='newemail']");

    public static Target campoUsuario = Target.the("campo usuario")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='newusername']");

    public static Target campoNombre = Target.the("campo nombre")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='first_name']");

    public static Target campoApellido = Target.the("campo apellido")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='last_name']");

    public static Target campoClave = Target.the("campo clave")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='password']");

    public static Target campoConfirmarClave = Target.the("campo confirmar clave")
            .locatedBy("//div[contains(@class,'b-right')]//input[@name='password_confirmation']");

    public static Target botonSignUp = Target.the("boton sign up")
            .locatedBy("//div[contains(@class,'b-right')]//button[@type='submit']");

    public static Target mensajeExito = Target.the("mensaje exito")
            .locatedBy("//div[contains(@class,'alert-success')]");

    public static Target mensajeError = Target.the("mensaje error")
            .locatedBy("//div[contains(@class,'alert-danger')]");
}
