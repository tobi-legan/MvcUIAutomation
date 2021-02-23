package todo;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PolymerPage;

public class TodoTests extends BaseTest {

    @Test
    public void InputTodo() throws InterruptedException {
        homePage.clickJavascriptTabButton();

        PolymerPage polymerPage = homePage.clickPolymerButton();

        polymerPage.enterTodo("Rest");
        polymerPage.enterTodo("Run");

        Assert.assertTrue(polymerPage.getFirstTodo().contains("Rest"), "This is not the correctly populated");
        Assert.assertTrue(polymerPage.getSecondTodo().contains("Run"), "This is not the correctly populated");
    }

    @Test
    public void UpdateSecondTodo() throws InterruptedException {
        homePage.clickJavascriptTabButton();

        PolymerPage polymerPage = homePage.clickPolymerButton();

        polymerPage.updateTodo("Mandem", polymerPage.getSecondTodo());
        Assert.assertTrue(polymerPage.getSecondTodo().contains("Mandem"), "This is not the correctly populated");

    }
}
