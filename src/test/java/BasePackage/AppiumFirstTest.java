package BasePackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static BasePackage.BaseClass.startServer;
import static BasePackage.BaseClass.stopServer;

public class AppiumFirstTest {

    static AppiumDriver<MobileElement> driver;
    static MobileElement element;

    public static void main(String args[])
    {

        try {
            startServer();
            calculator();
            stopServer();
        } catch (Exception e) {
           System.out.println(e.getCause());
           System.out.println(e.getMessage());
           e.printStackTrace();
        }
    }

    public static void calculator() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","OnePlusNord");
        cap.setCapability("udid","192.168.45.252:5555");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage","com.oneplus.calculator");
        cap.setCapability("appActivity","com.oneplus.calculator.Calculator");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url,cap);
        System.out.println("Application Started...");
        element = driver.findElement(By.id("com.oneplus.calculator:id/tooltips_cancel"));
        element.click();
        element = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
        element.click();
        element = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
        element.click();
        element = driver.findElement(By.id("com.oneplus.calculator:id/digit_3"));
        element.click();
        element = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
        element.click();
        String res = driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
        System.out.println(res);

    }

    public int solution(int N)
    {
        int x1 = 0;
        int x2 = 1;
        int x3 = 1;
        long count = 1000000000;
        long seq[] = new long[1000000000];
        for(long i=2; i<count; ++i )
        {
            x3 = x1 + x2;
            seq[(int) i] = x3;
            x1 = x2;
            x2 = x3;
        }
        // int seq[] = {0,1,1,2,3,5,8,13,12,7,10,8,9};
        return (int) seq[N];
    }
}
