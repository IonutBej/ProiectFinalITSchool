package SharedData.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeServiceBrowser implements iBrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser() {
        ChromeOptions options = (ChromeOptions) browserOptions();
        driver = new ChromeDriver(options);
    }

    @Override
    public Object browserOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        boolean ciCd = Boolean.parseBoolean(System.getProperty("ci_cd", "false"));

        if (ciCd) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-dev-shm-usage");
        }
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
