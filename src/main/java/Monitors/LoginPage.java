package Monitors;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Base {

    @FindBy (name = "username")
    WebElement username;

    @FindBy (name = "password")
    WebElement pass;

    @FindBy(css = "input[value=\"Log In\"]")
    WebElement loginbutton;

    @FindBy (linkText = "Register")
    WebElement registerbutton;

    public RegisterPage clickRegister(){
        registerbutton.click();
        return new RegisterPage();
    }
    public HomePage performLogin(){
        username.sendKeys(prop.getProperty("userName"));
        pass.sendKeys(prop.getProperty("Password"));
        loginbutton.click();
        return new HomePage();
    }

}
