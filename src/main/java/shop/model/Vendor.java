package shop.model;

import javax.persistence.Entity;

/**
 * Created by oleg on 11.03.16.
 */
@Entity(name = "vendors")
public class Vendor extends  BaseModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
