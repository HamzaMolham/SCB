package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Test;

public class RequestLoanTC extends Base {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void RequestLoanTC001(){
        loginPage = new LoginPage();
        homePage=loginPage.performLogin();
        homePage.enterLoanAmount();
        homePage.enterDownPayment();
    }
}
