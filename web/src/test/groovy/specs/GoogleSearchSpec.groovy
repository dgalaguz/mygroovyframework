package specs

import common.BaseTestSpec
import content.GoogleSearchPage

/**
 * Example spec - to show how specs and features should(can) be structured.
 */
class GoogleSearchSpec extends BaseTestSpec{
    def "Google Search"()
    {
        when: "Open Google Search page"
        def googlePage = page(GoogleSearchPage)
        to googlePage

        and: "Search"
        googlePage.search(query)

        then: "Verify the search results"
        googlePage.resultsAreDisplayed()
        //this is an intentional fail point, to demonstrate how failed features are reflected in report, see build/spock-reports
        1!=1

        //Data providers:
        where:
        query    | _
        "42"     | _
        "qwerty" | _
    }
}
