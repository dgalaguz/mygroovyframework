package content

import common.BaseTestPage
import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.Keys

class GoogleSearchPage extends BaseTestPage{
    static url = "https://www.google.com"

    static at = {searchField.displayed}

    static content = {
        searchField(wait: true){$(By.name('q')) }
        results(wait: true){$(By.id('search'))}
    }

    def search(String query){
        searchField.value(query)
        searchField << Keys.ENTER
    }

    def resultsAreDisplayed(){
        results.displayed
    }
}
