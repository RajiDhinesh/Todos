package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class TodoPage extends Base
{
    public TodoPage(WebDriver driver) {
        super();
    }

    By todo_Input = By.xpath("//input[@placeholder='What needs to be done?']");
    By todo_Count = By.xpath("//span[@class='todo-count']/strong");

public void enterToDO(String input)
{
    driver.findElement(todo_Input).sendKeys(input);
    driver.findElement(todo_Input).sendKeys(Keys.ENTER);

}

    public int verifyToDo()
    {
        return Integer.parseInt(driver.findElement(todo_Count).getText());

    }

    public void markToDo(String todo)
    {
        driver.findElement(By.xpath("//label[text()='" +
                todo +"']//parent::*//parent::li//input")).click();

    }

    public Boolean verifyCompletedToDo(String todo)
    {
        return driver.findElement(By.xpath("//label[text()='" +
                todo +"']//parent::*//parent::li")).getAttribute("Class").equals("ng-scope completed");

             }


    public void deleteToDo(String todo) throws InterruptedException {
        Thread.sleep(3000);
By btn=  By.xpath("//ul[@class='todo-list']//li//label[text()='"+todo+"']//following::button");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//label[text()='" +
                todo +"']//parent::*//parent::li//input"))).perform();
        //driver.findElement(btn).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(btn));

    }

    public List<String> verifydeletedToDo()
    {
       By totalTodos= By.xpath("//ul[@class='todo-list']//li//label");
        List<String> actual=new ArrayList();

        List<WebElement> headerlist= driver.findElements(totalTodos);
        System.out.println("size: "+headerlist.size());
        for(int i=0;i<headerlist.size();i++)
        {
            actual.add(i, headerlist.get(i).getText().toString());
        }
        return actual;
    }
    public List<String> verifyFilterToDo(String ToDo) {

    driver.findElement(By.xpath("//a[text()='"+ToDo+"']")).click();
       return verifydeletedToDo();
    }

}
