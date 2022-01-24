package Pages;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    public void launchBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\chromedriver.exe");
        //System.setProperty("webdriver.edge.driver", "C:\\New folder\\msedgedriver.exe");
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        System.out.println(url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void teardown(){
        driver.quit();
    }



    public  void takescreenshot() throws IOException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\New folder\\result\\"+sdf+".png");
        FileUtils.copyFile(SrcFile, DestFile);


    }
}
