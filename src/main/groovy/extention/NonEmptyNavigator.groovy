package extention

import geb.Browser
import geb.navigator.Navigator
import org.openqa.selenium.WebElement

import groovy.util.logging.Slf4j

/**
 * Automatically logs main interactions with the page content.
 * This class used as Geb inner navigator factory, see GebConfig.groovy
 */
@Slf4j
class NonEmptyNavigator extends geb.navigator.NonEmptyNavigator {
    NonEmptyNavigator(Browser browser, Collection<? extends WebElement> contextElements) {
        super(browser, contextElements)
    }

    @Override
    Navigator click() {
        log.info("Click on element [" + getElementLocator() + "]")
        super.click()
    }

    @Override
    def value() {
        def result = super.value()
        log.info("Get value from element [" + getElementLocator() + "] = '"+ result +"'")
        result
    }

    @Override
    Navigator value(value) {
        log.info("Set value '" + value + "' to element [" + getElementLocator() + "]")
        super.value(value)
    }

    @Override
    Navigator leftShift(value) {
        log.info("Set value '" + value + "' to element [" + getElementLocator() + "]")
        super.leftShift(value)
    }

    @Override
    String getAttribute(String name) {
        String result = super.getAttribute(name)
        log.info("Get attribute: '" + name + "' from element [" + getElementLocator() + "] = '" + result +"'")
        result
    }

    @Override
    boolean isDisplayed(){
        log.info("Check if element is displayed [" + getElementLocator() + "]")
        super.isDisplayed()
    }

    @Override
    String text() {
        String result = super.text()
        log.info("Get text from element [" + getElementLocator() + "] = '" + result +"'")
        result
    }


    def getElementLocator() {
        def locator = this.contextElements[0].toString()
        locator.substring(locator.indexOf('->')+3)[0..-2]
    }
}
