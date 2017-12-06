package net.mixolyde.kotlinbaseserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinbaseServerApplication

fun main(args: Array<String>) {
    runApplication<KotlinbaseServerApplication>(*args)
}
