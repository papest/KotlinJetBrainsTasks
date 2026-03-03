import kotlin.time.Duration.Companion.seconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.hours
import kotlin.time.DurationUnit

fun readDurationInSeconds(): Int =
    (readln().toInt().hours + readln().toInt().minutes + readln().toInt().seconds).toInt(DurationUnit.SECONDS)

fun main() = println(-(readDurationInSeconds() - readDurationInSeconds()))
