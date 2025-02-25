package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateInfoTC extends Base {

    LoginPage loginPage;
    HomePage homePage;

//    @Parameters ({"userName","Password","NewPhoneNumber"})

    @Test
    public void UpdateInfoTC001() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
        homePage.UpdateContact();

    }
}
