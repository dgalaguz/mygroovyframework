import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.INFO

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} %logger{0} %msg%n"
    }
}
appender("FILE", RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "log/generated %d{yyyy-MM-dd} %d{HH-mm-ss}.log"
        maxHistory = 7
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} %logger{0} %msg%n"
    }
}
root(INFO, ["FILE", "STDOUT"])