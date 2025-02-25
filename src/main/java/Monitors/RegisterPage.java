package Monitors;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base {

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement Caddress;

    @FindBy(id = "customer.address.city")
    WebElement Ccity;

    @FindBy(id = "customer.address.state")
    WebElement Cstate;

    @FindBy (id = "customer.address.zipCode")
    WebElement CzipCode;

    @FindBy (id = "customer.phoneNumber")
    WebElement Cphone;

    @FindBy (id = "customer.ssn")
    WebElement Cssn;

    @FindBy (id = "customer.username")
    WebElement username;

    @FindBy (id = "customer.password")
    WebElement pass;

    @FindBy (id = "repeatedPassword")
    WebElement repeatpass;

    @FindBy (css = "input[value =\"Register\"]")
    WebElement register;

    public void fillFirstName(){

        firstName.sendKeys(prop.getProperty("firstname"));
    }
    public void fillLastName(){

        lastName.sendKeys(prop.getProperty("lastname"));
    }
    public void fillAddress(){

        Caddress.sendKeys(prop.getProperty("street"));

    }
    public void fillCity(){

        Ccity.sendKeys(prop.getProperty("city"));
    }
    public void fillState(){

        Cstate.sendKeys(prop.getProperty("state"));

    }
    public void fillZipCode(){

        CzipCode.sendKeys(prop.getProperty("zipeCode"));
    }
    public void fillPhone(){

        Cphone.sendKeys(prop.getProperty("phoneNumber"));

    }
    public void fillSnn(){

        Cssn.sendKeys(prop.getProperty("ssn"));

    }
    public void fillUserName(){

        username.sendKeys(prop.getProperty("userName"));

    }
    public void fillPassword(){

        pass.sendKeys(prop.getProperty("Password"));

    }
    public void fillRepeatedPass(){
        repeatpass.sendKeys(prop.getProperty("repeatedPass"));
    }
    public HomePage clickRegisterButton(){

        register.click();
        return new HomePage();

    }
}
