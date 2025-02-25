package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Test;

public class TransfereFundTC extends Base {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void TransfereFundTC001(){
        loginPage = new LoginPage();
        homePage=loginPage.performLogin();
        homePage.performTransfer();
    }
}
