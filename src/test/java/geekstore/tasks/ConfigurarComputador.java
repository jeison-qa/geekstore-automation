package geekstore.tasks;

import geekstore.ui.ComputadorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfigurarComputador implements Task {

    private final String processor;
    private final String os;
    private final String ssd;
    private final String ram;

    public ConfigurarComputador(String processor, String os, String ssd, String ram) {
        this.processor = processor;
        this.os = os;
        this.ssd = ssd;
        this.ram = ram;
    }

    public static ConfigurarComputador con(String processor, String os, String ssd, String ram) {
        return instrumented(ConfigurarComputador.class, processor, os, ssd, ram);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ComputadorPage.processor, isVisible()).forNoMoreThan(15).seconds(),
                SelectFromOptions.byVisibleText(processor).from(ComputadorPage.processor),
                WaitUntil.the(ComputadorPage.os, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(os).from(ComputadorPage.os),
                WaitUntil.the(ComputadorPage.ssd, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(ssd).from(ComputadorPage.ssd),
                WaitUntil.the(ComputadorPage.ram, isVisible()).forNoMoreThan(5).seconds(),
                Clear.field(ComputadorPage.ram),
                Enter.theValue(ram).into(ComputadorPage.ram)
        );
    }
}