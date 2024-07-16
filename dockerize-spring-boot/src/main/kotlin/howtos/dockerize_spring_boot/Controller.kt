package howtos.dockerize_spring_boot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @GetMapping("/static/text")
    fun getStaticText(): String {
        return "Static text"
    }
}