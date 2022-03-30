package rtu.recruit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import rtu.recruit.enums.PaymentType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "checks")
public class CheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserEntity user;

    @OneToMany(targetEntity = CheckItemEntity.class, mappedBy = "check",
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CheckItemEntity> items;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType payment;

    @Column(name = "closed")
    private boolean closed;

    @Column(name = "total")
    private double total;

    public CheckEntity() {
        items = new ArrayList<>();
    }

    public CheckEntity(long id, UserEntity user, PaymentType payment, boolean closed, double total) {
        this.id = id;
        this.user = user;
        this.payment = payment;
        this.closed = closed;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CheckItemEntity> getItems() {
        return items;
    }

    public void setItems(List<CheckItemEntity> items) {
        this.items = items;
    }

    public PaymentType getPayment() {
        return payment;
    }

    public void setPayment(PaymentType payment) {
        this.payment = payment;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addItem(CheckItemEntity item) {
        items.add(item);
    }
}
