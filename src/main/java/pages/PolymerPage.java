package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolymerPage {

    private WebDriver driver;
    private By todoInputField = By.id("new-todo");
    private By firstTodoLocator = By.xpath("/html/body/div/td-todos/section/section/ul/li/div/label");
    private By secondTodoLocator = By.xpath("/html/body/div/td-todos/section/section/ul/li[2]/div/label");


    public PolymerPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     *
     * @param todo :  the todo that the user wants to input
     * @param fieldLocator:  the Input field Locator that the user wants to pass the todo value
     *   When this method is called, the fieldLocator is first cleared, before the todo value is passed in the locator and the
     *   return key is pressed
     */
    public void enterTodoLogic(String todo, By fieldLocator){
        driver.findElement(fieldLocator).clear();
        driver.findElement(fieldLocator).sendKeys(todo);
        driver.findElement(fieldLocator).sendKeys(Keys.RETURN);
    }

    /**
     *
     * @param todo Collects the todo that the user wants to input
     */
    public void enterTodo(String todo){
        enterTodoLogic(todo, todoInputField);
    }

    /**
     *
     * @param todoLocator Collects the locator of the todo
     *
     * @return The value of the todo
     */
    public String getEnteredTodo(By todoLocator){
        return driver.findElement(todoLocator).getText();
    }


    public String getFirstTodo(){
        return getEnteredTodo(firstTodoLocator);
    }

    public String getSecondTodo(){
        return getEnteredTodo(secondTodoLocator);
    }

    /**
     *
     * @param todo the todo that the user wants to input
     * @param formerTodo the todo former todo value
     * @throws InterruptedException
     */
    public void updateTodo(String todo, String formerTodo) throws InterruptedException {
        Actions actions = new Actions(driver);

        for (int i = 0; i < formerTodo.length()-1 ; i++){
            actions.doubleClick(driver.findElement(secondTodoLocator)).
                    sendKeys(Keys.BACK_SPACE).
                    sendKeys(Keys.RETURN).
                    build().
                    perform();
        }

        actions.doubleClick(driver.findElement(secondTodoLocator)).
                sendKeys(Keys.BACK_SPACE).
                sendKeys(todo).
                sendKeys(Keys.RETURN).
                build().
                perform();

    }
}
