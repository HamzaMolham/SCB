package Monitors;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends Base {

    @FindBy (className = "smallText")
    WebElement accountName;

    @FindBy (linkText = "Open New Account")
    WebElement newAccount;

    @FindBy (id = "customer.phoneNumber")
    WebElement Cphone;

    @FindBy (linkText = "Update Contact Info")
    WebElement update;

    @FindBy (css = "input[value=\"Update Profile\"]")
    WebElement updateButton;

    @FindBy(css = "select[class=\"input\"]")
    WebElement selectType;

    @FindBy(linkText = "Log Out")
    WebElement logOut;

    @FindBy (id = "fromAccountId")
    WebElement selectAccount;

    @FindBy (css = "input[value=\"Open New Account\"]")
    WebElement NewAccountButton;

    @FindBy (linkText = "Transfer Funds")
    WebElement Transfer;

    @FindBy (id = "amount")
    WebElement amount;

    @FindBy (id = "fromAccountId")
    WebElement selectFromAccount;

    @FindBy (id = "toAccountId")
    WebElement selectToAccount;

    @FindBy (linkText = "Request Loan")
    WebElement requestLoan;

    @FindBy (id = "amount")
    WebElement loanAmount;

    @FindBy (id = "downPayment")
    WebElement downPayment;

    @FindBy (id = "fromAccountId")
    WebElement selectloanAccount;

    @FindBy (id = "loanStatus")
    WebElement loanStatus;

    @FindBy (css = "input[value=\"Apply Now\"]")
    WebElement applyButton;

    @FindBys({
            @FindBy(how = How.ID, using = "accountTable"),
            @FindBy (css = "thead>tr")}
    )
    private List<WebElement> tablecolumns;

    @FindBy (linkText = "Accounts Overview")
    WebElement overView;





    public void IsAccountNameDisplayed(){
        soft.assertTrue(accountName.isDisplayed());
        soft.assertAll();
    }

    public void UpdateContact() throws InterruptedException {
        update.click();
        Cphone.clear();
        Cphone.sendKeys(prop.getProperty("NewPhoneNumber"));
        Thread.sleep(300);
        updateButton.click();
    }

    public void openNewAccount() throws InterruptedException {
        newAccount.click();
        Select dropdown = new Select(selectType);
        Select dropdwon_2 = new Select(selectAccount);
        dropdown.getOptions().get(1).click();
        dropdwon_2.getOptions().get(0);
        NewAccountButton.click();
    }

    public void performLogout(){
        logOut.click();
    }

    public void performTransfer(){
        Transfer.click();
        Select dropdown = new Select(selectFromAccount);
        Select dropdown_1 = new Select(selectToAccount);
        amount.sendKeys(prop.getProperty("Amount"));
        dropdown.getOptions().get(0);
        dropdown_1.getOptions().get(0);


    }

    public void enterLoanAmount(){
        requestLoan.click();
        loanAmount.sendKeys(prop.getProperty("LoanAmount"));
    }

    public void enterDownPayment(){
        downPayment.sendKeys(prop.getProperty("DownPayment"));
        Select dropdown = new Select(selectloanAccount);
        dropdown.getOptions().get(0);
        applyButton.click();
        soft.assertTrue(loanStatus.isDisplayed());
    }

    public void getBalanceAndTotal(){
        overView.click();
      System.out.println(tablecolumns.get(0));

    }


}
