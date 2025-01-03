package com.amazon.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

import static com.amazon.utilities.readPropertiesForm.loadProperties;

public class WebTestBase {

    public static WebDriver driver;
    static Properties readProperty= loadProperties("src/main/resources/Configuration.properties");//Calling the method from the readPropertiesForm and set up properties file connection
   public static String browserName = readProperty.getProperty("BROWSER_NAME");
    public static String envUrl = readProperty.getProperty("QA_ENV_URL");


    public static String BROWSERSTACK_USER_NAME = System.getenv("BROWSERSTACK_USER_NAME");
    public static String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static String SAUCE_LABS_USERNAME = System.getenv("SAUCE_LABS_USERNAME");
    public static String SAUCE_LABS_ACCESS_KEY = System.getenv("SAUCE_LABS_ACCESS_KEY");
    String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
    String local = System.getenv("BROWSERSTACK_LOCAL");
    String Localidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");



    public static void setUpBrowser() throws InterruptedException, MalformedURLException {
        //public static void setUpBrowser( String envName,String os,String osVersion,String browserName,String browserVersion) throws InterruptedException, MalformedURLException {
        //Cloud Infrastructure: BrowserStack or SauceLab
        boolean useCloudEnv=true;
        if (useCloudEnv == true) {
            getCloudDriver("browserName","OS X","Big Sur",WebTestBase.browserName,"120.0");
        } else {
            setBrowser(WebTestBase.browserName);

        }
        System.out.println("ENV URL==== "+envUrl);
        driverSetUp(envUrl);
    }
        public static void driverSetUp(String envUrl) {

            driver.get(envUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

        public static void getCloudDriver(String envName,String os,String osVersion,String browserName,String browserVersion) throws MalformedURLException {//create that method for the useCloudDriver

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("browserVersion", browserVersion);
            HashMap<String, Object> options = new HashMap<String, Object>();
            options.put("os", os);
            options.put("osVersion", osVersion);
            options.put("seleniumVersion", "4.26.0");

//            options.put("sessionName", "BStack Build Name: " + buildName);// these 3 no need
//            options.put("local", local);
//            options.put("localIdentifier", localIdentifier);





        if(envName.equalsIgnoreCase("browserStack")){

            capabilities.setCapability("bstack:options", options);//this line move from the top
            driver = new RemoteWebDriver(new URL("https://" + BROWSERSTACK_USER_NAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub.browserstack.com/wd/hub"), capabilities);

            }
        else if(envName.equalsIgnoreCase("sauceLabs")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(os);
            browserOptions.setBrowserVersion(browserVersion);
            options.put("build", "selenium-build-KLW8W");
            browserOptions.setCapability("name", "<your test name>");
            browserOptions.setCapability("sauce:options", options);
            capabilities.setCapability("osVersion", osVersion);
            URL url = new URL("https://" + SAUCE_LABS_USERNAME + ":" + SAUCE_LABS_ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        }





        }

    public static void setBrowser(String browserName){
        if(Objects.equals(browserName,"chrome")){
            driver = new ChromeDriver();
        }
    }

    public static void driverClose() throws InterruptedException{
            driver.close();// to close the website from the browser
    }

    public static void driversleep() throws InterruptedException{
        Thread.sleep(5000);//use to keep wait the browser so i can input the code
    }


    }

