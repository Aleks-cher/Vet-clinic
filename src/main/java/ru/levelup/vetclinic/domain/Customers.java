package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@ToString(exclude = {"service", "recordingVetsList", "animalList"})
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

//    @ManyToMany
//    @JoinTable(
//            name = "customers_and_organization",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "organization_id")
//    )
//    private List<Organization> organizations;
    @ManyToMany
    @JoinTable(
            name = "payments",
            joinColumns = @JoinColumn(name = "customer_personnel_number"),
            inverseJoinColumns = @JoinColumn(name = "service_personnel_number")
    )
    private List<Services> service;
    @ManyToMany
    @JoinTable(
            name = "payments",
            joinColumns = @JoinColumn(name = "customer_personnel_number"),
            inverseJoinColumns = @JoinColumn(name = "recording_date")
    )
    private List<RecordingVets> recordingVetsList;
}
