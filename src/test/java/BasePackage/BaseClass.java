package BasePackage;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class BaseClass {
    private static AppiumDriverLocalService service = null;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities Dcap;
    private static int port = 4723;

    public static void startServer() {
        Dcap = new DesiredCapabilities();
        Dcap.setCapability("noReset", "false");

        // Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.1.1,1");
        builder.usingPort(port);
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        builder.withAppiumJS(new File("C:\\Users\\uic37006\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        builder.withCapabilities(Dcap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
//        HashMap<String, String> environment = new HashMap();
//        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
//        builder.withEnvironment(environment);
        // Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }
    public static void stopServer()
    {
       service.stop();
    }
}
