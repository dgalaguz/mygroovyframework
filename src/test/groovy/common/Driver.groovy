package common

import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.Point
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

import org.openqa.selenium.Dimension

import java.awt.Toolkit

/**
 * Driver creation
 */
class Driver {

    static driverInstance

    static synchronized getInstance(browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions()
                    options.addArguments("disable-infobars")

                    ChromeDriverManager.getInstance().setup()
                    driverInstance = new ChromeDriver(options)

                    driverInstance.manage().window().setPosition(new  Point(0,0))
                    driverInstance.manage().window().setSize(new Dimension(Toolkit.defaultToolkit.getScreenSize().width.toInteger(), Toolkit.defaultToolkit.getScreenSize().height.toInteger()))

                    driverInstance
                    break
                case "firefox":
                    FirefoxDriverManager.getInstance().setup()
                    driverInstance = new FirefoxDriver()

                    driverInstance.manage().window().maximize()

                    driverInstance
                    break
            }
        } else {
            driverInstance
        }
    }

}
