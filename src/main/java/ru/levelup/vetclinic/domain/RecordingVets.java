package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Getter
@ToString(exclude = {"customer", "animal", "vet", "service", "customersList"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recording_vets")
public class RecordingVets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
//    @Column(name = "customer_personnel_number")
//    private String customerPersonnelNumber;
    @ManyToOne
    @JoinColumn(
            name = "customer_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Customers customer;
//    @Column(name = "animal_personnel_number")
//    private String animalPersonnelNumber;
    @ManyToOne
    @JoinColumn(
            name = "animal_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Animals animal;
//    @Column(name = "vet_personnel_number")
//    private String vetPersonnelNumber;
    @ManyToOne
    @JoinColumn(
            name = "vet_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Vets vet;
//    @Column(name = "service_personnel_number")
//    private String servicePersonnelNumber;
    @ManyToOne
    @JoinColumn(
            name = "service_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Services service;
    @Column(name = "date")
    private Timestamp date;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "recordingVetsList",
            cascade = CascadeType.ALL
    )
    private List<Customers> customersList;

    public RecordingVets(Integer id, Customers customer, Animals animal, Vets vet, Services service, Timestamp date) {
        this.id = id;
        this.customer = customer;
        this.animal = animal;
        this.vet = vet;
        this.service = service;
        this.date = date;
    }
}
