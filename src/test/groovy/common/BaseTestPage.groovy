package common

import geb.Page
import groovy.util.logging.Slf4j
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

@Slf4j
class BaseTestPage extends Page {

    @Override
    void to(Map params, Object... args) {
        log.info("Navigate to page: " + getClass().simpleName)
        super.to(params, args)
    }

    @Override
    void onLoad(Page previousPage) {
        log.info("Loading page: " + browser.getCurrentUrl())
        super.onLoad(previousPage)
    }

    @Override
    boolean verifyAt() {
        log.info("Verify at page: " + getClass().simpleName)
        return super.verifyAt()
    }
    

    def clickOnElementUsingJS(WebElement element) {
        try{
            String locator = element.toString()
            locator = locator.substring(locator.indexOf('->')+3)[0..-2]

            ((JavascriptExecutor)driver).executeScript("arguments[0].click()", element)

            log.info("Click on element Using JS [" + locator + "]")
            return true
        }
        catch (Exception e){
            log.info("WARNING - Click failed" )
            return false
    }
    }

    /**
     * Scrolls to the web element
     * Web element is placed in the middle of the screen after function is applied
     * @param element
     * @return
     */
    def scrollToElementUsingJS(WebElement element){
        try {
            int position = element.location.y
            int screenHeight = driver.manage().window().size.height
            int scrollToY = position - screenHeight / 2
            String locator = element.toString()
            locator = locator.substring(locator.indexOf('->')+3)[0..-2]

            js.exec('window.scrollTo(0,' + (scrollToY).toString() + ')')

            log.info("Scrolled To Elemant Using JS [" + locator + "]")
            log.info("Element position Y: " + position)
            return true

        } catch (Exception e){
            log.info("WARNING - Scroll failed" )
            return false
        }
    }
}
