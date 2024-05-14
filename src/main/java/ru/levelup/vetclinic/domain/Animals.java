package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@ToString(exclude = "customer")
@NoArgsConstructor

@Entity
@Table(name = "animals")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "personnel_number")
    private String personnelNumber;
    @Column(name = "animal_name")
    private String animalName;
    //    @Column(name = "animal_type")
//    private String animalType;
    @Column(name = "animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "customer_id")
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Customers customer;

    public Animals(Integer id, String personnelNumber, String animalName, AnimalType animalType, Timestamp date, Customers customer) {
        this.id = id;
        this.personnelNumber = personnelNumber;
        this.animalName = animalName;
        this.animalType = animalType;
        this.date = date;
        this.customer = customer;
    }


}
