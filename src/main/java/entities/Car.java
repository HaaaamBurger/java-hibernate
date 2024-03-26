package entities;

import enums.ECarType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "CAR", schema = "public")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private ECarType type;

    @Column(name = "speed")
    private short speed;

    @Column(name = "price")
    private int price;

    @Column(name = "year")
    private short year;

    @ManyToOne(cascade = {})
    private Owner owner;

    public Car setModel(String model) {
        this.model = model;
        return this;
    }
    public Car setType(ECarType type) {
        this.type = type;
        return this;
    }
    public Car setSpeed(short speed) {
        this.speed = speed;
        return this;
    }
    public Car setPrice(int price) {
        this.price = price;
        return this;
    }
    public Car setYear(short year) {
        this.year = year;
        return this;
    }
}
