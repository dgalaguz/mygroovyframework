package content
import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.Keys

class GoogleSearchPage extends Page{
    static url = "https://www.google.com"

    static at = {searchField.displayed}

    static content = {
        searchField(wait: true){$(By.name('q')) }
        results(wait: true){$(By.id('search'))}
    }

    def search(String query){
        def field = searchField.firstElement()
        field.sendKeys(query)
        field.sendKeys(Keys.ENTER)
    }

    def resultsAreDisplayed(){
        results.displayed
    }
}
