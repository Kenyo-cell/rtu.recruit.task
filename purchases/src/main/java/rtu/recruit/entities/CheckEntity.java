package rtu.recruit.entities;

import rtu.recruit.enums.PaymentType;

import javax.persistence.*;

@Entity
@Table(name = "checks")
public class CheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType payment;

    @Column(name = "total")
    private double total;
}
