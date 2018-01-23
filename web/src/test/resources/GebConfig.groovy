import common.Driver
import utils.CommonUtils
import extention.NonEmptyNavigator
import geb.Browser
import geb.navigator.EmptyNavigator
import org.openqa.selenium.WebElement


driver = { Driver.getInstance(System.properties.getProperty("browser"))}
baseUrl = CommonUtils.ReadDataFromPath(System.properties.getProperty("pathToTestData")).baseUrl

//Geb runtime reports
reportsDir = new File("build/geb_runtime_reports")

//Custom inner navigator factory for logging, see: NonEmptyNavigator
innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
    elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator(browser)
}
