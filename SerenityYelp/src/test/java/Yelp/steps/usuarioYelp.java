package Yelp.steps;

import Yelp.pageobject.paginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class usuarioYelp extends ScenarioActor {
    String actor;

    @Steps(shared = true)
    paginaPrincipal paginaPrincipal;
}
