package utils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Provides the number of the current Fork to the common.logback.
 * Useful when multiple tests run in parallel.
 * Helps keep track of which fork is logging.
 */
class GradleTestWorkerConverter extends ClassicConverter{
    @Override
    String convert(ILoggingEvent event) {
        return "Fork #:" + (System.properties['org.gradle.test.worker'].toInteger() - 1)
    }
}
