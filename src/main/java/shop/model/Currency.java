package shop.model;

import javax.persistence.*;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "currencies")
public class Currency extends BaseModel{
    private String name;
    private Integer rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
