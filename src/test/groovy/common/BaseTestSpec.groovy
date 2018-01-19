package common

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import org.apache.commons.io.FileUtils
import org.yaml.snakeyaml.util.UriEncoder
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
            screenshots.each {FileUtils.copyFile(it, new File("build/spock-reports/screenshots/" + specName + "/" + it.name))}

            def screenshotsWithLinks = screenshots.collectEntries {[(it.name) :"screenshots/"+ specName + "/" + UriEncoder.encode(it.name)]}

            reportHeader("<b>Screenshots of Failed features:</b>")
            screenshotsWithLinks.each{reportHeader('<a href='+ it.value +' target="_blank">'+ it.key +'</a>')}
        }
    }
}
