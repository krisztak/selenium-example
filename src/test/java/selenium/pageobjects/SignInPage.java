package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class SignInPage extends Pages {

    public SignInPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//INPUT[@id='login_field']")
    private WebElement username;

    @FindBy(xpath = "//INPUT[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//INPUT[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//DIV[@class='container']")
    private WebElement error;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/a[1]/svg[1]")
    private WebElement home;

    public void submitLoginCredentials(String user, String pass){
        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys();
        submitButton.click();
    }

    public String getErrorMessage(){
        return error.getText();
    }

    public void returnHome(){
        home.click();
    }


}
