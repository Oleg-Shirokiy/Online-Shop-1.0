package shop.model;

import javax.persistence.*;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "attributes")
public class Attribute extends BaseModel{
    @OneToOne
    ProductContent productContent;

    String name;
    String measurement;
    String value;

    public ProductContent getProductContent() {
        return productContent;
    }

    public void setProductContent(ProductContent productContent) {
        this.productContent = productContent;
    }

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
