package common

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * Driver creation and basic configuration
 */
class Driver {

    static driverInstance

    static synchronized getInstance(browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "android_real":
                    DesiredCapabilities capabilities = new DesiredCapabilities()
                    capabilities.setCapability("deviceName","Android")
                    capabilities.setCapability("platformName", "android")
                    capabilities.setCapability("platformVersion", "7")
                    capabilities.setCapability("appPackage", "com.android.calculator2")
                    capabilities.setCapability("appActivity", "com.android.calculator2.Calculator")

                    driverInstance = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
                    driverInstance
                    break
            }
        } else {
            driverInstance
        }
    }

}
