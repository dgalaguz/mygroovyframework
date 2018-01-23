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
 * Driver creation and basic configuration
 * Currently implemented browsers: chrome, firefox
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

                    /*
                    Browser maximizing implemented this way because of WebDriver issue with mac and linux.
                    If two tests start in parallel one browser is going to be maximized and the other is not.
                    This is specific only to chrome(mac, linux).
                    Following code resolves this problem.
                    */
                    if (System.properties['os.name'].toLowerCase().contains('windows')){
                        driverInstance.manage().window().maximize()
                    }
                    else
                    {
                        driverInstance.manage().window().setPosition(new  Point(0,0))
                        driverInstance.manage().window().setSize(new Dimension(Toolkit.defaultToolkit.getScreenSize().width.toInteger(), Toolkit.defaultToolkit.getScreenSize().height.toInteger()))
                    }

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
