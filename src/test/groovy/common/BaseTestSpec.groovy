package common

import com.athaydes.spockframework.report.SpecInfoListener
import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import spock.lang.IgnoreIf
import spock.lang.Shared
import sun.security.provider.SHA

@Slf4j
class BaseTestSpec extends GebReportingSpec{
    @Shared def specName =  specificationContext.currentSpec.name
    @Shared def listener = specificationContext.currentSpec.listeners.find{it.class == SpecInfoListener}

    def setup(){
        log.info("Starting...")
    }

    def cleanupSpec(){
        def runs = listener.specData.featureRuns
        def specFolder = new File(browser.config.reportsDir.path + "\\specs\\" + specName)
        def screenshots = specFolder.listFiles().findAll {it.name.endsWith("failure.png")}
        if(screenshots){
            reportHeader("<b>Screenshots of Failures:</b>")
            screenshots.eachWithIndex {item, index -> reportHeader('<a href='+ item.toURI() +'>'+ 'screenshot '+ (index+1) +'</a>')}
        }
    }
}
