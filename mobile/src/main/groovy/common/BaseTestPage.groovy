package common

import geb.Page
import groovy.util.logging.Slf4j

/**
 * All of your app Pages should be extended from this class.
 * It Provides logging.
 */

@Slf4j
class BaseTestPage extends Page {
    @Override
    boolean verifyAt() {
        log.info("Verify at page: " + getClass().simpleName)
        return super.verifyAt()
    }
}
