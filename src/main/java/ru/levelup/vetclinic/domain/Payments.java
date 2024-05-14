package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Getter

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_personnel_number")
    private String customerPersonnelNumber;
    @Column(name = "service_personnel_number")
    private String servicePersonnelNumber;
    @Column(name = "recording_date")
    private Timestamp recordingDate;
    @ManyToOne
    @JoinColumn(
            name = "service_personnel_number",
            referencedColumnName = "personnel_number", insertable = false, updatable = false
    )
    private Services service;

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", customerPersonnelNumber='" + customerPersonnelNumber + '\'' +
                ", servicePersonnelNumber='" + servicePersonnelNumber + '\'' +
                ", recordingDate=" + recordingDate +
                ", serviceName = " + service.getServiceName() + " price: " + service.getPrice() +
                '}';
    }

    public Payments(Integer id, String customerPersonnelNumber, String servicePersonnelNumber, Timestamp recordingDate) {
        this.id = id;
        this.customerPersonnelNumber = customerPersonnelNumber;
        this.servicePersonnelNumber = servicePersonnelNumber;
        this.recordingDate = recordingDate;
    }
}
