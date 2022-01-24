package stepDefinition;


import Pages.Base;
import Pages.TodoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class StepDef extends Base{

    private Base base;
    public StepDef( Base base)
    {
        this.base=base;
    }
    TodoPage todoPage = new TodoPage(Base.driver);
    @Given("^I launch todomvc$")
    public void launch_webpage(DataTable data) throws Throwable{
        List<List<String>> obj = data.cells();
        System.out.println("URL "+obj.get(0).get(0));
        base.launchBrowser(obj.get(0).get(0));
    }
    @And("^I add todos$")
    public void add_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        for(int i=0;i< obj.size();i++) {
            todoPage.enterToDO(obj.get(i).get(0));
        }
    }

    @And("^I Verify the added todos$")
    public void verify_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        Assert.assertEquals("Count is not Matching",todoPage.verifyToDo(),obj.size());
    }

    @And("^I mark the completed todos$")
    public void mark_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        for(int i=0;i< obj.size();i++) {
            todoPage.markToDo(obj.get(i).get(0));
        }
    }

    @And("^I Verify the competed todos$")
    public void verify_completed_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        for(int i=0;i< obj.size();i++) {
            Assert.assertEquals("To do is not completed",
                    todoPage.verifyCompletedToDo(obj.get(i).get(0)),Boolean.TRUE);
        }

    }

    @And("^I delete any of the todos$")
    public void delete_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        for(int i=0;i< obj.size();i++) {
            todoPage.deleteToDo(obj.get(i).get(0));
        }
    }

    @And("^I Verify the item got removed$")
    public void verify_deleted_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        List<String> actual = todoPage.verifydeletedToDo();
        for(int i=0;i<obj.size();i++)
        {
            Assert.assertEquals(obj.get(i).get(0)+" ToDo is not deleted",
                    actual.contains(obj.get(i).get(0)), false);

        }
    }

    @And("^I Verify the filters are working$")
    public void verify_Filters_todos(DataTable data) throws InterruptedException {
        List<List<String>> obj = data.cells();
        for(int i=0;i<obj.size();i++) {
            List<String> actual = todoPage.verifyFilterToDo(obj.get(i).get(0));
            System.out.println(obj.get(i).size());
            for (int j = 1; j <obj.get(i).size(); j++) {
                System.out.println(obj.get(i).get(j));
                if(obj.get(i).get(j)!=null) {
                    Assert.assertEquals(obj.get(i).get(j) + "" +
                                    "Filter is not matching",
                            actual.contains(obj.get(i).get(j)), true);
                }
            }
        }
    }
}
