package utils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

class GradleTestWorkerConverter extends ClassicConverter{
    @Override
    String convert(ILoggingEvent event) {
        return "Fork #:" + (System.properties['org.gradle.test.worker'].toInteger() - 1)
    }
}
