package stepDefinition;
import Pages.Base;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import java.sql.Driver;
public class hooks  {

    private Base base;

    public hooks(Base base) {
        this.base = base;
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario)  {
        System.out.println(scenario.getName()+" is " + scenario.getStatus());
    }
    @After
    public void teardown(){
        Base b = new Base();
       b.teardown();
    }
}
