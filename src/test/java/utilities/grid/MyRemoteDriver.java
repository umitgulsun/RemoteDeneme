package utilities.grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyRemoteDriver
{
    private static WebDriver crossDriver;
    public static WebDriver getRemoteDriverSetup(String url, AbstractDriverOptions options)
    {
        try
        {
            crossDriver = new RemoteWebDriver(new URL(url), options);
        }
        catch(MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
        crossDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        crossDriver.manage().window().maximize();
        return crossDriver;
    }
    public static WebDriver getRemoteDriver()
    {
        return crossDriver;
    }
    public static AbstractDriverOptions getOptions(String browserOptions)
    {
        AbstractDriverOptions options = null;
        if(browserOptions.equals("chrome"))
            options = new ChromeOptions();
        else if(browserOptions.equals("firefox"))
            options = new FirefoxOptions();
        else if(browserOptions.equals("edge"))
            options = new EdgeOptions();
        return options;
    }
}
