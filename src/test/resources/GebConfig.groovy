import extention.NonEmptyNavigator
import geb.Browser
import geb.navigator.EmptyNavigator
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

ChromeDriverManager.getInstance().setup()

driver = { new ChromeDriver() }
reportsDir = new File("target/runtime_reports_dir")

innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
    elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator(browser)
}
