package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "animal_type")
    private String animalType;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "customer_id")
    private long customerId;
//    @OneToMany(
//            mappedBy = "animals",
//            fetch = FetchType.LAZY
//    )
//    private List<Customers> customer;


}
