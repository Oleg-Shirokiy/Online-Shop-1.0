package shop.model;

import javax.persistence.*;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "attributes")
public class Attribute extends BaseModel{
    @OneToOne
    ProductContent productContent;

    @OneToOne
    AttributeTemplate attributeTemplate;

    String value;

    public ProductContent getProductContent() {
        return productContent;
    }

    public void setProductContent(ProductContent productContent) {
        this.productContent = productContent;
    }

    public AttributeTemplate getAttributeTemplate() {
        return attributeTemplate;
    }

    public void setAttributeTemplate(AttributeTemplate attributeTemplate) {
        this.attributeTemplate = attributeTemplate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
