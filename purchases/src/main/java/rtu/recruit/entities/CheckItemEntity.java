package rtu.recruit.entities;

import rtu.recruit.entities.keys.CheckItemId;

import javax.persistence.*;

@Entity
@Table(name = "check_item")
@IdClass(CheckItemId.class)
public class CheckItemEntity {
    @Id
    private long checkId;

    @Id
    private long productId;

    @ManyToOne
    @JoinColumn(name = "check_id")
    private CheckEntity check;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private double count;

    public CheckItemEntity() {}

    public CheckItemEntity(long checkId, long productId, double count) {
        this.checkId = checkId;
        this.productId = productId;
        this.count = count;
    }

    public long getCheckId() {
        return checkId;
    }

    public void setCheckId(long checkId) {
        this.checkId = checkId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
