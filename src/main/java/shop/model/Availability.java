package shop.model;

import javax.persistence.*;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "availability")
public class Availability extends BaseModel{
    String status;
    Integer deliveryTerm;

    public boolean hasDeliveryTerm() {
        return deliveryTerm != null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDeliveryTerm() {
        return deliveryTerm;
    }

    public void setDeliveryTerm(Integer deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }
}
