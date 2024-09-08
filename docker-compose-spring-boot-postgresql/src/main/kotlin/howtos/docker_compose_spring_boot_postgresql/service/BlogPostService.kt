package howtos.docker_compose_spring_boot_postgresql.service

import howtos.docker_compose_spring_boot_postgresql.dto.BlogPostCreationRequest
import howtos.docker_compose_spring_boot_postgresql.entity.BlogPost
import howtos.docker_compose_spring_boot_postgresql.exception.BlogPostNotFoundException
import howtos.docker_compose_spring_boot_postgresql.repository.BlogPostRepository
import org.springframework.stereotype.Service

@Service
class BlogPostService(
    private val blogPostRepository: BlogPostRepository
) {
    fun createBlogPost(blogpost: BlogPostCreationRequest): BlogPost {
        return blogPostRepository.saveAndFlush(BlogPost(blogpost.heading, blogpost.body))
    }

    fun getBlogPostById(id: Long): BlogPost {
        return blogPostRepository.findById(id).orElseThrow { BlogPostNotFoundException() }
    }
}