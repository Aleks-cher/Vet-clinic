package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Getter

@NoArgsConstructor

@Entity
@Table(name = "recording_vets")
public class RecordingVets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(
            name = "customer_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Customers customer;
    @ManyToOne
    @JoinColumn(
            name = "animal_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Animals animal;
    @ManyToOne
    @JoinColumn(
            name = "vet_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Vets vet;
    @ManyToOne
    @JoinColumn(
            name = "service_personnel_number",
            referencedColumnName = "personnel_number"
    )
    private Services service;
    @Column(name = "date")
    private Timestamp date;

    @Override
    public String toString() {
        return "RecordingVets{" +
                "id=" + id +
                ", customer=" + customer.getPersonnelNumber() +
                ", animal=" + animal.getPersonnelNumber() +
                ", vet=" + vet.getPersonnelNumber() +
                ", service=" + service.getPersonnelNumber() +
                ", date=" + date +
                '}';
    }

    public RecordingVets(Integer id, Customers customer, Animals animal, Vets vet, Services service, Timestamp date) {
        this.id = id;
        this.customer = customer;
        this.animal = animal;
        this.vet = vet;
        this.service = service;
        this.date = date;
    }
}
