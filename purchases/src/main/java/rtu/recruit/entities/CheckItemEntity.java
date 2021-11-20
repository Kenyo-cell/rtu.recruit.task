package rtu.recruit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import rtu.recruit.entities.keys.CheckItemId;

import javax.persistence.*;

@Entity
@Table(name = "check_items")
public class CheckItemEntity {

    @EmbeddedId
    @JsonProperty("id")
    private CheckItemId itemId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id", insertable = false, updatable = false)
    @JsonIgnore
    private CheckEntity check;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "cnt")
    private double count;


    public CheckItemEntity() {}

    public CheckItemEntity(CheckItemId itemId, double count) {
        this.itemId = itemId;
        this.count = count;
    }

    public long getCheckId() {
        return itemId.getCheckId();
    }

    public void setCheckId(long checkId) {
        this.itemId.setCheckId(checkId);
    }

    public long getProductId() {
        return itemId.getProductId();
    }

    public void setProductId(long productId) {
        this.itemId.setProductId(productId);
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public CheckEntity getCheck() {
        return check;
    }

    public void setCheck(CheckEntity check) {
        this.check = check;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
