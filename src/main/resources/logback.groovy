import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import utils.GradleTestWorkerConverter
import static ch.qos.logback.classic.Level.INFO

/**
 * Logging configuration
 */

conversionRule("worker", GradleTestWorkerConverter)

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "[%worker] %d{HH:mm:ss:SSS} %logger{0} %msg%n"
    }
}
appender("FILE", RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "log/generated %d{yyyy-MM-dd} %d{HH-mm}.log"
        maxHistory = 7
    }
    encoder(PatternLayoutEncoder) {
        pattern = "[%worker] %d{HH:mm:ss:SSS} %logger{0} %msg%n"
    }
}
root(INFO, ["FILE", "STDOUT"])