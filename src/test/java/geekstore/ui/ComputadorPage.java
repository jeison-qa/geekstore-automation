package geekstore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ComputadorPage {

    public static Target botonBuildComputer = Target.the("boton build your own computer")
            .locatedBy("//a[@data-id='1']");

    public static Target processor = Target.the("processor")
            .locatedBy("//select[@id='prod-req-1']");

    public static Target os = Target.the("os")
            .locatedBy("//select[@id='prod-req-2']");

    public static Target ssd = Target.the("ssd capacity")
            .locatedBy("//select[@id='prod-req-7']");

    public static Target ram = Target.the("ram")
            .locatedBy("//input[@id='prod-req-3']");

    public static Target botonAgregar = Target.the("boton agregar")
            .locatedBy("//button[@id='addtocart-submit']");

    public static Target mensajeErrorRam = Target.the("mensaje error ram")
            .locatedBy("//p[@id='invalid-ram']");
}