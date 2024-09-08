package howtos.docker_compose_spring_boot_postgresql.dto

data class BlogPostCreationRequest(
    val heading: String,
    val body: String
)

data class BlogPostCreationResponse(
    val id: Long,
    val heading: String,
    val body: String
)

data class SingleBlogPostFetchResponse(
    val heading: String,
    val body: String
)