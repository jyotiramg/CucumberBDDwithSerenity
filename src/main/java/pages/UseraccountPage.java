package pages;

import base.Util;
import base.WebElementFunctions;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;

public class UseraccountPage extends PageObject {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public UseraccountPage(final WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        open();
    }

    public void usernamePassword(String Email, String password) {
        try {

            Thread.sleep(10000);
            Util.switchToNewWindow(getDriver());
            //Thread.sleep(5000);
            WebElementFunctions.tb_EnterText(Util.getXpath(getClass().getSimpleName(), "Email"), Email, getDriver());
            //Thread.sleep(5000);
            WebElementFunctions.tb_EnterText(Util.getXpath(getClass().getSimpleName(), "Password"), password, getDriver());
            //Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("User Enter the Email and password");
    }

    public void clickonLoginbutton() {
        try {
            Thread.sleep(5000);
            WebElementFunctions.btn_Click(Util.getXpath(getClass().getSimpleName(), "LoginButton"), getDriver());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}



