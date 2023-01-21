package cucumbersteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.UseraccountPage;

public class UseraccountPageSteps extends ScenarioSteps {

    public UseraccountPage useraccountPage;

    public UseraccountPageSteps(final Pages pages) {
        super(pages);
        this.useraccountPage=getPages().getPage(UseraccountPage.class);
    }

    @Given("^user navigate to the Geoscience INTEGRATOR$")
    public void user_navigate_to_the_Geoscience_INTEGRATOR_application() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        this.useraccountPage.navigate();
        //Thread.sleep(5000);
    }

    @When("^user enter the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_the_and(String Email, String password ) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        this.useraccountPage.usernamePassword(Email,password);
        System.out.println("User enter the email and Password");
    }

    @When("^user click on Login button$")
    public void user_click_on_Login_button() {
        // Write code here that turns the phrase above into concrete actions
        this.useraccountPage.clickonLoginbutton();
        System.out.println("user click on login button");
    }

    @Then("^verify user will login successfully$")
    public void verify_user_will_login_successfully() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("login success");

    }
}