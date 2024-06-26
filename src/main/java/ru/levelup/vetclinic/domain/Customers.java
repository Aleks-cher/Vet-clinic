package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = "animalList")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "personnel_number")
    private String personnelNumber;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date")
    private Timestamp date;
    @OneToMany(mappedBy = "customer")
    private List<Animals> animalList;


    public Customers(Integer id, String personnelNumber, String lastName, String firstName, String middleName, String phoneNumber, Timestamp date) {
        this.personnelNumber = personnelNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.id = id;
    }
}
