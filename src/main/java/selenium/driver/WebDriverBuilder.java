package selenium.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverBuilder {

    private String name;
    private final WebDriverConfig webDriverConfig;
    private String userAgent;
    private boolean disableCookies;

    public WebDriverBuilder(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void userAgent(final UserAgents userAgent) {
        this.userAgent = userAgent.getValue();
    }

    public void disableCookies(boolean cookies) {
        this.disableCookies = cookies;
    }


    public WebDriver toWebDriver() {
        DesiredCapabilitiesFactory desiredCapabilitiesFactory = new DesiredCapabilitiesFactory();
        DesiredCapabilities capabilities = desiredCapabilitiesFactory.initDesiredCapabilities(webDriverConfig, userAgent, disableCookies);
        String browser = webDriverConfig.getBrowserName();

        switch (browser) {
            case "firefox":
                MarionetteDriverManager.getInstance().setup();
                FirefoxDriver firefoxDriver = new FirefoxDriver(capabilities);
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;
            case "edge":
                EdgeDriverManager.getInstance().setup();
                final EdgeDriver edgeDriver = new EdgeDriver(capabilities);
                edgeDriver.manage().window().maximize();
                return edgeDriver;
            case "opera":
                OperaDriverManager.getInstance().setup();
                final OperaDriver operaDriver = new OperaDriver(capabilities);
                operaDriver.manage().window().maximize();
                return operaDriver;
            default:
                ChromeDriverManager.getInstance().setup();
                final ChromeDriver chromeDriver = new ChromeDriver(capabilities);
                chromeDriver.manage().window().maximize();
                return chromeDriver;

        }
    }
}
