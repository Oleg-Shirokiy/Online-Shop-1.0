package shop.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by oleg on 10.03.16.
 */
@Entity(name = "attribute_templates")
public class AttributeTemplate extends BaseModel{

    String name;
    String measurement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }


}
