import common.Driver
import extension.NonEmptyNavigator
import geb.Browser
import geb.navigator.EmptyNavigator
import org.openqa.selenium.WebElement


driver = { Driver.getInstance(System.properties.getProperty("driver"))}

//Geb runtime reports
reportsDir = new File("build/geb_runtime_reports")

//Custom inner navigator factory for logging, see: common/src/main/groovy/extension/NonEmptyNavigator.groovy
innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
    elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator(browser)
}
