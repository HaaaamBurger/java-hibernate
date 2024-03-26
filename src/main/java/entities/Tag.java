package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "TAGS", schema = "public")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    @ManyToMany(mappedBy = "tags", cascade = {})
    private List<Owner> owners;

    public Tag setTitle(String title) {
        this.title = title;
        return this;
    }
}
