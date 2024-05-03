package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recording_vets")
public class RecordingVets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_personnel_number")
    private String customerPersonnelNumber;
    @Column(name = "animal_personnel_number")
    private String animalPersonnelNumber;
    @Column(name = "vet_personnel_number")
    private String vetPersonnelNumber;
    @Column(name = "service_personnel_number")
    private String servicePersonnelNumber;
    @Column(name = "date")
    private Timestamp date;
}
