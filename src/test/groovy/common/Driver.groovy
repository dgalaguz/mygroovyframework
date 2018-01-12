package common

import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.safari.SafariOptions

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
                    options.addArguments("--start-maximized")
                    options.addArguments("--test-type")
                    options.addArguments("disable-infobars")

                    if (System.properties['os.name'].toLowerCase().contains('mac')){
                        options.addArguments("--start-fullscreen")
                        //options.addArguments("--kiosk")
                    }
                    ChromeDriverManager.getInstance().setup()
                    driverInstance = new ChromeDriver(options)
                    driverInstance
                    break
//                case "remote_chrome":
//                    DesiredCapabilities caps = new DesiredCapabilities()
//                    caps.setBrowserName("chrome")
//                    WebDriver driverInstance = new RemoteWebDriver(Environment.remoteUrl.toURL(), caps)
////                    driverInstance.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS)
//                    driverInstance.manage().window().maximize()
//                    driverInstance
//                    break
//                case "firefox":
//                case "ff":
//                    String extension = "";
//                    if (System.properties['os.name'].toLowerCase().contains('windows')) extension = ".exe"
//                    if (System.properties['os.name'].toLowerCase().contains('mac'))     extension = "_mac"
//                    System.setProperty('webdriver.gecko.driver', Environment.getCWD() + '/src/main/resources/geckodriver' + extension)
//                    println("Driver location: " + Environment.getCWD() + '/src/main/resources/geckodriver' + extension)
//                    FirefoxProfile profile = new FirefoxProfile()
////                    profile.setPreference("app.update.service.enabled", false)
////                    profile.setPreference("app.update.auto", false)
////                    profile.setPreference("app.update.enabled", false)
////                    //automatically download pdf's
////                    profile.setPreference("browser.download.folderList", 1)
////                    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf")
////                    profile.setPreference("pdfjs.disabled", true)
//
////                    profile.setEnableNativeEvents(false)
//                    driverInstance = new FirefoxDriver(profile)
////                    driverInstance.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS)
//                    driverInstance.manage().window().maximize()
//                    driverInstance
//                    break
//                case "ie":
//                    def ieDriver = new File('src/test/resources/IEDriverServer.exe')
//                    System.setProperty('webdriver.ie.driverInstance', ieDriver.absolutePath)
//                    DesiredCapabilities caps = DesiredCapabilities.internetExplorer()
//                    caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true)
//                    caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1)
//                    caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false)
//                    caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false)
//                    driverInstance = new InternetExplorerDriver(caps)
////                    driverInstance.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS)
//                    driverInstance.manage().window().maximize()
//                    driverInstance
//                    break
//                case "safari":
//                    def remoteUrl = Environment.remoteUrl.toURL()
//                    DesiredCapabilities caps = DesiredCapabilities.safari()
//                    def opts = new SafariOptions()
//                    opts.useCleanSession = true
//                    caps.setCapability(SafariOptions.CAPABILITY, opts)
//                    driverInstance = new RemoteWebDriver(remoteUrl, caps)
////                driverInstance = new SafariDriver(caps)
////                driverInstance.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS)
//                    driverInstance.manage().window().maximize()
//                    driverInstance
//                    break
            }
        } else {
            driverInstance
        }
    }

}
