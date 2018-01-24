package specs

import common.BaseTestSpec
import content.GoogleSearchPage

/**
 * Second example spec - to show how multiple specs can be run in parallel
 */
class GoogleSearchSpec2 extends BaseTestSpec{
    def "Google Search"()
    {
        when: "Open Google Search page"
        def googlePage = page(GoogleSearchPage)
        to googlePage

        and: "Search"
        googlePage.search("42")

        then: "Verify the search results"
        googlePage.resultsAreDisplayed()
    }
}
