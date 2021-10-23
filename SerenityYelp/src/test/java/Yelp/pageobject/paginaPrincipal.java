package Yelp.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class paginaPrincipal extends PageObject {

    @FindBy(xpath = "//*[@id='find_desc']")
    WebElementFacade findButton;

    @FindBy(xpath = "//*[@data-suggest-query='Restaurants']")
    WebElementFacade RestaurantsItem;

    @FindBy(xpath = "//input[@id='search_description']")
    WebElementFacade searchBox;

    @FindBy(xpath = "//form[@id='header_find_form']//button[@value='submit']")
    WebElementFacade searchButton;

    @FindBy(xpath = "//p[contains(text(),'Neighborhoods')]//following::a[1]")
    WebElementFacade seeAllNeighbor;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    WebElementFacade searchFilterButton;

    @FindBy(xpath = "//*[contains(text(),'Phone number')]//following-sibling::p")
    WebElementFacade restaurantPhone;

    @FindBy(xpath = "//*[contains(text(),'Get Directions')]//parent::p//following-sibling::p")
    WebElementFacade restaurantAddress;

    @FindBy(xpath = "//span[contains(text(),'Yelp Sort')]/parent::button")
    WebElementFacade reviewSortByButton;

    @FindBy(xpath = "//*[contains(text(),'Oldest First')]//ancestor::button")
    WebElementFacade oldesFirstButtn;

    public void searchRestaurant() {
        findButton.click();
        RestaurantsItem.click();
    }

    public void searchTypeRestaurant(String restaurant) {
        searchBox.clear();
        searchBox.sendKeys(restaurant);
        searchButton.click();
    }

    public void se

}
