package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Test;

public class LoginTC extends Base {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void LoginTC001(){

        loginPage = new LoginPage();
        homePage=loginPage.performLogin();
        homePage.IsAccountNameDisplayed();

    }
}
