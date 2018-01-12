import common.Driver
import common.utils.Utils
import extention.NonEmptyNavigator
import geb.Browser
import geb.navigator.EmptyNavigator
import org.openqa.selenium.WebElement


driver = { Driver.getInstance(System.properties.getProperty("browser"))}
baseUrl = Utils.ReadDataFromPath(Utils.getPathForTestData()).baseUrl

reportsDir = new File("target/runtime_reports_dir")

innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
    elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator(browser)
}
