package ru.levelup.vetclinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString(exclude = "paymentsList")
@NoArgsConstructor
@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "personnel_number")
    private String personnelNumber;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "price")
    private BigDecimal price;


    @OneToMany(
            mappedBy = "service", fetch = FetchType.EAGER
    )
    private List<Payments> paymentsList;

    public Services(Integer id, String personnelNumber, String serviceName, BigDecimal price) {
        this.id = id;
        this.personnelNumber = personnelNumber;
        this.serviceName = serviceName;
        this.price = price;
    }
}
