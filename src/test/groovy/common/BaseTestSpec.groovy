package common

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j

@Slf4j
class BaseTestSpec extends GebReportingSpec{
    def setup(){
        log.info("Starting...")
    }
}
