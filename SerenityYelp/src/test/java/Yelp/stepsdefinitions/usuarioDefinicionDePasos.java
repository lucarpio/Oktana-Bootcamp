package Yelp.stepsdefinitions;

import Yelp.steps.usuarioYelp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class usuarioDefinicionDePasos {

    @Steps(shared = true)
    usuarioYelp usuario;

    @Given("^User navigates to https://www.yelp.com/$")
    public void userNavigateYelp() {

    }

    @And("^Selects find Restaurants$")
    public void userSearch() {

    }

    @Given("^User search restaurant (.*)$")
    public void userSearchRestaurant(String restaurant) {

    }

    @When("^Filters by (.*)$")
    public void userFilterBy(String neighborhood) {

    }

    @And("^Select the first search result$")
    public void userSelectFirstResult() {

    }

    @Then("^User views restaurant information$")
    public void userViewDetails() {

    }
}
