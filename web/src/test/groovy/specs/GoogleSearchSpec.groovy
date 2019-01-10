package specs

import common.BaseTestSpec
import content.GoogleSearchPage
import org.testng.annotations.Test
import geb.Browser
import geb.Page
import org.testng.internal.TestNGMethod
import ru.yandex.qatools.allure.annotations.Description


/**
 * Example spec - to show how specs and features should(can) be structured.
 */
@Test
class GoogleSearchSpec extends BaseTestSpec{
    @Description("This is an example test suite")
    @Test
    void "Google Search"()
    {
        def browser = new Browser()
        browser.go("https://stackoverflow.com/questions/30085879/why-does-my-geb-test-return-failed-to-create-driver-from-callback-even-after-u")
//        def googlePage = browser.page(GoogleSearchPage)
//        browser.to (googlePage)
//
//        googlePage.search"42"
//
//        googlePage.resultsAreDisplayed()
        // This is an intentional fail point, to demonstrate how failed features are reflected in report, see build/spock-reports
        1!=1
    }
}
