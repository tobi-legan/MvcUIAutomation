package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By javaScriptTabButton = By.xpath("//div[@id='tabsContent']/paper-tab[1]/div");
    private By polymerButton = By.linkText("Polymer");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickJavascriptTabButton(){
        driver.findElement(javaScriptTabButton).click();
    }

    public PolymerPage clickPolymerButton() throws InterruptedException {
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", driver.findElement(polymerButton));
        Thread.sleep(300);
        return new PolymerPage(driver);
    }
}
