package common

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import org.apache.commons.io.FileUtils
import org.yaml.snakeyaml.util.UriEncoder
import spock.lang.Shared

/**
 * All of your Specs should be extended from this class.
 */

@Slf4j
class BaseTestSpec extends GebReportingSpec{
    @Shared def specName =  specificationContext.currentSpec.name

    /**
     * Runs before each feature
     */
    def setup(){
        log.info("Starting " + specificationContext.currentFeature.name + " feature")
    }

    /**
     * Runs before each spec
     */
    def setupSpec(){
        log.info("Starting " + specName + " spec")
    }

    /**
     * Runs after each spec.
     * Screenshots are added to the report after each spec is completed.
     */
    def cleanupSpec(){
        // Geb runtime reports directory. Screenshots of failures saved here in runtime.
        def specFolder = new File(browser.config.reportsDir.path + "/specs/" + specName)
        // Collecting all the "failure" screenshots
        def screenshots = specFolder.listFiles().findAll {it.name.endsWith("failure.png")}

        // If any screenshots were made:
        if(screenshots){
            // Copy screenshots to the spock-reports dir.
            screenshots.each {FileUtils.copyFile(it, new File("build/spock-reports/screenshots/" + specName + "/" + it.name))}

            // Generating relative URLs for the screenshots.
            def screenshotsWithLinks = screenshots.collectEntries {[(it.name) :"screenshots/"+ specName + "/" + UriEncoder.encode(it.name)]}

            // Adding the links to screenshots to the report header.
            reportHeader("<b>Screenshots of Failed features:</b>")
            screenshotsWithLinks.each{reportHeader('<a href='+ it.value +' target="_blank">'+ it.key +'</a>')}
        }
    }
}
