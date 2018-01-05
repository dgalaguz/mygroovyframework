import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

ChromeDriverManager.getInstance().setup()

driver = { new ChromeDriver() }
reportsDir = new File("target/runtime_reports_dir")