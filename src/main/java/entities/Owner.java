package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "OWNER", schema = "public")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "owner",cascade = {}, fetch = FetchType.LAZY)
    private List<Car> cars;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "license_id")
    private License license;

    public Owner setName(String name) {
        this.name = name;
        return this;
    }
    public Owner setCars(List<Car> cars) {
        this.cars = cars;
        cars.forEach(car -> car.setOwner(this));
        return this;
    }
    public Owner setLicense(License license) {
        this.license = license;
        return this;
    }
}
