package jordhan.felix.todolist_backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_priorities")
public class Priority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Priority() {
    }

    public Priority(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {
        LOW(1L, "low"),
        MEDIUM(2L,"medium"),
        HIGH(3L, "high");

        private Long id;
        private String description;

        Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Priority get(){
            return new Priority(id, description);
        }
    }
}