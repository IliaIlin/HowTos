package howtos.dockerize_spring_boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerizeSpringBootApplication

fun main(args: Array<String>) {
	runApplication<DockerizeSpringBootApplication>(*args)
}
