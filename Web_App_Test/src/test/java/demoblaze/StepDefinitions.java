package demoblaze;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private String strUsername = "UserDemoBlase0009";
    private String strPassword = "53cur1ty.P4s5";
    private String productSelected = "MacBook air";

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.demoblaze.com/");
    }

    @When("user navigate to login")
    public void user_navigate_to_login() {
        driver.findElement(By.id("login2")).click();
    }

    @When("user navigate to signup")
    public void user_navigate_to_signup() {
        driver.findElement(By.id("signin2")).click();
    }

    @When("user enters username and password in login")
    public void user_enters_username_and_password_in_login() {
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));
        WebElement loginSend = driver.findElement(By.xpath("(//button[@type='button'])[9]"));

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(strUsername);
        password.sendKeys(strPassword);
        loginSend.click();
    }

    @When("user enters username and password in signup")
    public void user_enters_username_and_password_in_signup() {
        WebElement usernameSignup = driver.findElement(By.id("sign-username"));
        WebElement passwordSignup = driver.findElement(By.id("sign-password"));
        WebElement signupSend = driver.findElement(By.xpath("//*[@id='signInModal']/div/div/div[3]/button[2]"));

        wait.until(ExpectedConditions.visibilityOf(usernameSignup));
        usernameSignup.sendKeys(strUsername);
        passwordSignup.sendKeys(strPassword);
        signupSend.click();
    }

    @When("Add a laptop to the cart")
    public void Add_a_laptop_to_the_cart(){
        driver.findElement(By.xpath("//*[@id='itemc'][2]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("MacBook air")));
        driver.findElement(By.linkText("MacBook air")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add to cart")));
        driver.findElement(By.linkText("Add to cart")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Product added.", closeAlertAndGetItsText());
    }

    @Then("success signup message is displayed")
    public void success_signup_message_is_displayed(){
        wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("Sign up successful.", closeAlertAndGetItsText());
        driver.close();
    }

    @Then("success login message is displayed")
    public void success_login_message_is_displayed() {
        String expectedText = "Welcome " + strUsername;
        long timeOut = 20;

        wait.until(ExpectedConditions.textToBePresentInElement(By.id("nameofuser"), expectedText));

        String currentText = driver.findElement(By.id("nameofuser")).getText();
        Assert.assertEquals(expectedText, currentText);
    }

    @Then("Check the laptop was added to cart")
    public void Check_the_laptop_was_added_to_cart(){
        /*WebElement menuCart = driver.findElement(By.id("cartur"));
        WebElement productTitle = driver.findElement(By.xpath("//tbody[@id='tbodyid']/tr/td[2]"));
        WebElement deleteProduct = driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]"));

         */

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cartur")));
        driver.findElement(By.id("cartur")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[2]")));
        String title = driver.findElement(By.xpath("//tbody[@id='tbodyid']/tr/td[2]")).getText();
        Assert.assertEquals(title, productSelected);

        driver.quit();
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
