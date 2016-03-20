package shop.model;

import javax.persistence.Entity;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "order_statuses")
public class OrderStatus extends BaseModel {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
