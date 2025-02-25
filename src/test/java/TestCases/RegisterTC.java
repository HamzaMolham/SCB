package TestCases;

import Base.Base;
import Monitors.HomePage;
import Monitors.LoginPage;
import Monitors.RegisterPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTC extends Base {

    LoginPage loginpage;
    RegisterPage registerpage;
    HomePage homePage;


//    @Parameters({"firstname","lastname","street","city","state","zipeCode","phoneNumber","ssn","userName",
//            "Password","repeatedPass"   })
    @Test
    public void RegisterTC001 (){
       loginpage = new LoginPage();
       registerpage = loginpage.clickRegister();
       registerpage.fillFirstName();
       registerpage.fillLastName();
       registerpage.fillAddress();
       registerpage.fillCity();
       registerpage.fillState();
       registerpage.fillZipCode();
       registerpage.fillPhone();
       registerpage.fillSnn();
       registerpage.fillUserName();
       registerpage.fillPassword();
       registerpage.fillRepeatedPass();
      homePage = registerpage.clickRegisterButton();
       homePage.IsAccountNameDisplayed();
    }
}
