package howtos.docker_compose_spring_boot_postgresql.repository

import howtos.docker_compose_spring_boot_postgresql.entity.BlogPost
import org.springframework.data.jpa.repository.JpaRepository

interface BlogPostRepository : JpaRepository<BlogPost, Long>