package entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "LICENSE", schema = "public")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String series;

    @OneToOne(mappedBy = "license")
    private Owner owner;

    public License setSeries(String series) {
        this.series = series;
        return this;
    }
}
