package sw2.lab5.Entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private String idpost;

    @Column(name = "author_id")
    @Size(max = 11,message = "Máximo 11 caracteres")
    private int authorid;

    @Size(max = 75,message = "Máximo 75 caracteres")
    private String title;

    private String summary;

    private Boolean published;

    private String content;
}
