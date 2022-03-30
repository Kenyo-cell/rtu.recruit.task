package rtu.recruit.entities.keys;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CheckItemId implements Serializable {
    @Column(name = "check_id", insertable = false, updatable = false)
    @JsonProperty(value = "check_id")
    private long checkId;
    @JsonProperty(value = "product_id")
    @Column(name = "product_id", insertable = false, updatable = false)
    private long productId;

    public CheckItemId() {
    }

    public CheckItemId(long checkId, long productId) {
        this.checkId = checkId;
        this.productId = productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckItemId that = (CheckItemId) o;
        return checkId == that.checkId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, productId);
    }
}
