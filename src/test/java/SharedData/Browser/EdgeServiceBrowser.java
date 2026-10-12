package SharedData.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeServiceBrowser implements iBrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser() {

        EdgeOptions options = (EdgeOptions) browserOptions();
        driver = new EdgeDriver(options);
    }

    @Override
    public Object browserOptions() {

        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");

        boolean ciCd = Boolean.parseBoolean(System.getProperty("ci_cd", "false"));

        if (ciCd) {
            options.addArguments("--headless=new");
        }
        return options;
    }
    public WebDriver getDriver() {
        return driver;
    }
}