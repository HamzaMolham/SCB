package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Test;

public class OpenNewAccountTC extends Base {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void OpenNewAccountTC001() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
        homePage.openNewAccount();
    }
}
