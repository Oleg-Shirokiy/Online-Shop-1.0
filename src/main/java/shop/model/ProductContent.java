package shop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "product_contents")
public class ProductContent extends BaseModel{
    @OneToOne
    Product product;

    private String description;
    private String imageLinks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productContent", fetch = FetchType.LAZY)
    List<Attribute> attributes;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

}
