package howtos.docker_compose_spring_boot_postgresql.entity

import jakarta.persistence.*

@Entity
@Table(name = "BlogPost")
class BlogPost() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blogPostId")
    var blogPostId: Long? = null

    @Column(name = "heading", nullable = false)
    var heading: String? = null

    @Column(name = "body", nullable = false)
    var body: String? = null

    constructor(heading: String, body: String) : this() {
        this.heading = heading
        this.body = body
    }
}

