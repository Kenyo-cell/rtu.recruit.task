package rtu.recruit.entities.keys;

import javax.persistence.Column;
import java.io.Serializable;

public class CheckItemId implements Serializable {
    @Column(name = "check_id")
    private long checkId;

    @Column(name = "product_id")
    private long productId;

    public CheckItemId() {}

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
}
