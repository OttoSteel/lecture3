package support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static support.DriverManager.getDriver;

public class MainTest {
    public static void main(String[] args) {
        /*WebDriver driver = getDriver();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/"); //admin147ajyvk0/
        WebElement input = driver.findElement(By.cssSelector("input[name=s]"));
        input.sendKeys("Dress");
        input.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withMessage("Products are not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("products")));
        WebElement product = driver.findElement(By.cssSelector(".js-product-miniature"));
        WebElement previewLink = driver.findElement(By.cssSelector(".quick-view"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofSeconds(5)).click(previewLink)
                .build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".quickview")));

        driver.quit();*/
        WebDriver driver = DriverManager.getConfiguredDriver("chrome");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        // Filling email-feld:
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("webinar.test@gmail.com");
        // Filling password-field:
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");
        // Submit form:
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        // Clicking the buttons on the main menu:
        WebElement katalog = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Каталог")));
        WebElement categories = driver.findElement(By.id("subtab-AdminCategories"));
        Actions actions = new Actions(driver);
        actions.moveToElement(katalog).pause(Duration.ofSeconds(5)).click(categories)
                .build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        // Waiting for the page load:
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
        // Clicking 'Добавить категорию':
        WebElement addCategory = driver.findElement(By.cssSelector("a[title='Добавить категорию']"));
        addCategory.click();
        // Waiting for the page load:
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
        // Create new category:
        WebElement categiryInput = driver.findElement(By.id("name_1"));
        categiryInput.sendKeys("test category");
        WebElement categorySubmit = driver.findElement(By.id("category_form_submit_btn"));
        categorySubmit.click();
        // Check success-message presence:
        WebDriverWait waitForSuccessMessage = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert.alert-success")));
        // Filtering categories by name:
        WebElement filter = driver.findElement(By.name("categoryFilter_name"));
        filter.sendKeys("test category");
        WebElement searchButton = driver.findElement(By.id("submitFilterButtoncategory"));
        searchButton.click();
        WebDriverWait waitForResultPresense = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()[contains(.,'test category')]]")));
        System.out.println("EVERYTHING OK");
        driver.quit();
    }


}
