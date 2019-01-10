package common

import groovy.util.logging.Slf4j
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest

import java.lang.reflect.Method

/**
 * All of your Specs should be extended from this class.
 */

@Slf4j
class BaseTestSpec {
    /**
     * Runs before each feature.
     */
    @BeforeMethod(alwaysRun = true)
    void setup(){
        log.info("Starting feature\n")
    }

    /**
     * Runs after each feature.
     */
    @AfterMethod(alwaysRun = true)
    void cleanup(){
        log.info("Feature end\n")
    }

    /**
     * Runs before each spec.
     */
    @BeforeClass
    static void setupSpec(){
        log.info("Starting spec\n")
    }

    /**
     * Runs after each spec.
     * Screenshots are added to the report after each spec is completed.
     */
//    def cleanupSpec(){
//        log.info("Spec end\n")
//
//        // Geb runtime reports directory. Screenshots of failures saved here in runtime.
//        def specFolder = new File(browser.config.reportsDir.path + "/specs/" + specName)
//        // Collecting all the "failure" screenshots.
//        def screenshots = specFolder.listFiles().findAll {it.name.endsWith("failure.png")}
//
//        // If any screenshots were made:
//        if(screenshots){
//            // Copy screenshots to the spock-reports dir.
//            screenshots.each {FileUtils.copyFile(it, new File("build/spock-reports/screenshots/" + specName + "/" + it.name))}
//
//            // Generating relative URLs for the screenshots
//            def screenshotsWithLinks = screenshots.collectEntries {[(it.name) :"screenshots/"+ specName + "/" + UriEncoder.encode(it.name)]}
//
//            // Adding the links to screenshots to the report header.
//            reportHeader("<b>Screenshots of Failed features:</b>")
//            screenshotsWithLinks.each{reportHeader('<a href='+ it.value +' target="_blank">'+ it.key +'</a>')}
//        }
//    }
}
