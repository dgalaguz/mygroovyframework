package common

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import spock.lang.IgnoreIf
import spock.lang.Shared

@Slf4j
class BaseTestSpec extends GebReportingSpec{
    @Shared def specName =  specificationContext.currentSpec.name

    def setup(){
        log.info("Starting...")
    }

    def cleanupSpec(){
        def specFolder = new File(browser.config.reportsDir.path + "\\specs\\" + specName)
        def screenshots = specFolder.listFiles().findAll {it.name.endsWith("failure.png")}
        if(screenshots){
            reportHeader("<b>Screenshots of Failures:</b>")
            screenshots.eachWithIndex {item, index -> reportHeader('<a href='+ item.toURI() +'>'+ 'screenshot '+ (index+1) +'</a>')}
        }
    }
}
