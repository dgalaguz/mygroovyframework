package common

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.remote.DesiredCapabilities

import java.awt.*

/**
 * Driver creation and basic configuration
 */
class Driver {

    static driverInstance

    static synchronized getInstance(browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "android_real":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("deviceName","Android");

                    capabilities.setCapability("platformName", "android");
                    capabilities.setCapability("platformVersion", "7");
                    capabilities.setCapability("os", "android");
                    capabilities.setCapability("os_version", "7");

                    capabilities.setCapability("app", "")

                    driverInstance = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    driverInstance
                    break
            }
        } else {
            driverInstance
        }
    }

}
