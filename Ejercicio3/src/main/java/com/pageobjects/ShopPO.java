package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPO {
    private final WebDriver driver;

    @FindBy(xpath = "//li[contains(@class, \"ajax_block_product\")]")
    private List<WebElement> productView;

    @FindBy(id = "short_description_content")
    private WebElement productDescription;

    @FindBy(id = "our_price_display")
    private WebElement productPrice;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBys(xpath = "//li[contains(@id,\"thumbnail_\")]")
    private List<WebElement> detailImages;

    @FindBy(id = "group_1")
    private WebElement productSizes;

    @FindBy(xpath = "//p[@id=\"add_to_cart\"]/button/")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//span[contains(.,\"Continue\") and contains(@class,\"btn\")]")
    private WebElement contShoppingBtn;

    public ShopPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContinueShopping() {
        contShoppingBtn.click();
    }

    public void clickOnSelectProduct(int product) {
        productView.get(product).click();
    }

    public int verifyDetails(){
        return detailImages.size();
    }

    public String getProductSize(){
        return productSizes.getText();
    }

    public void selectProductQuantity(){
        productQuantity.clear();
        productQuantity.sendKeys("" + Math.random() * 5 + 1);
    }

    public void setProductSize(){
        Select sizeSelect = new Select(productSizes);
        sizeSelect.selectByVisibleText("L");
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public void getProductData() {
        String productDescriptionContent = productDescription.getText();
        String productPriceContent = productPrice.getText();
        System.out.println("Product desc: " + productDescriptionContent + "\nProduct price: " + productPriceContent);
    }




}
