package howtos.docker_compose_spring_boot_postgresql

import howtos.docker_compose_spring_boot_postgresql.dto.BlogPostCreationRequest
import howtos.docker_compose_spring_boot_postgresql.dto.BlogPostCreationResponse
import howtos.docker_compose_spring_boot_postgresql.dto.SingleBlogPostFetchResponse
import howtos.docker_compose_spring_boot_postgresql.exception.BlogPostNotFoundException
import howtos.docker_compose_spring_boot_postgresql.service.BlogPostService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.*

@RestController
class BlogPostController(
    private val blogPostService: BlogPostService
) {

    @GetMapping("/blogPosts/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBlogPostById(@PathVariable id: Long): ResponseEntity<SingleBlogPostFetchResponse?> {
        val blogPost = blogPostService.getBlogPostById(id)
        if (blogPost.heading == null || blogPost.body == null) {
            throw IllegalStateException("One or more attributes of blogpost are null, please verify")
        }
        return ResponseEntity.status(HttpStatus.OK)
            .body(SingleBlogPostFetchResponse(blogPost.heading!!, blogPost.body!!))
    }

    @PostMapping(
        "/blogPosts",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createBlogPost(@RequestBody request: BlogPostCreationRequest): ResponseEntity<BlogPostCreationResponse> {
        val createdBlogPost = blogPostService.createBlogPost(request)
        if (createdBlogPost.blogPostId == null || createdBlogPost.heading == null || createdBlogPost.body == null) {
            throw IllegalStateException("One or more attributes of created blogpost are null, please verify")
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(
                BlogPostCreationResponse(
                    createdBlogPost.blogPostId!!,
                    createdBlogPost.heading!!,
                    createdBlogPost.body!!
                )
            )
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorResponse> {
        return when (ex) {
            is BlogPostNotFoundException ->
                ResponseEntity.noContent()
                    .build()

            else -> ResponseEntity.internalServerError()
                .body(
                    ErrorResponse.builder(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server error")
                        .build()
                )
        }
    }
}