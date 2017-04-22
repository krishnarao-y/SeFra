package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SampleTestClass extends BaseTest{
    private WebElement element;

    @Parameters({ "expected_text" })
    @Test(groups = { "Smoke", "SampleModule" })
    public void testMethod(String expected_text)
    {
        element = new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        element.sendKeys("Persistent Systems");

        element = driver.findElement(By.name("btnG"));
        element.click();

        Assert.assertTrue(driver.getPageSource().contains(expected_text), "Expected text not found on page!");
    }
}
