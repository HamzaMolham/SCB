package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import org.testng.annotations.Test;

public class LogoutTC extends Base {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void LogoutTC001(){
        loginPage=new LoginPage();
        homePage=loginPage.performLogin();
        homePage.performLogout();
    }
}
