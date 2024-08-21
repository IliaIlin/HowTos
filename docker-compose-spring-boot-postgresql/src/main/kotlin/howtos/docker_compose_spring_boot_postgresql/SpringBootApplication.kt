package howtos.docker_compose_spring_boot_postgresql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerizeSpringBootApplication

fun main(args: Array<String>) {
	runApplication<DockerizeSpringBootApplication>(*args)
}
