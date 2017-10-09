package mjrgr.test.app.logging

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.io.File
import java.util.Objects.isNull
import java.util.concurrent.atomic.AtomicLong

@SpringBootApplication
@EnableScheduling
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(value = "mjrgr.test.app")
class LoggingTestAppStarter

fun main(args: Array<String>) {
    if (isNull(System.getenv("logsDir"))) System.setProperty("logsDir", "${System.getProperty("java.io.tmpdir")}${File.separator}logging-app${File.separator}logs")
    SpringApplication.run(LoggingTestAppStarter::class.java, *args)
}

@Component
class ScheduledLogger {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ScheduledLogger::class.java)
        private val COUNTER = AtomicLong(0)
    }

    /**
     * just puts a log every 5 seconds
     */
    @Scheduled(cron = "*/5 * * * * *")
    fun logIt() {
        LOGGER.info("Hi! I'm a the test log number ${COUNTER.getAndIncrement()}")
    }
}