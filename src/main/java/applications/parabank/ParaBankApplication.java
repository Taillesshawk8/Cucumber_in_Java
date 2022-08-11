package applications.parabank;

import Roman.Roman;
import applications.parabank.pages.AccountPage;
import applications.parabank.pages.LoginPage;

public class ParaBankApplication {
    public LoginPage loginPage;
    public AccountPage accountPage;

    public ParaBankApplication(Roman roman){
        loginPage = new LoginPage(roman);
        accountPage = new AccountPage(roman);
    }
}
