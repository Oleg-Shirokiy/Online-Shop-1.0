package shop.model;

import javax.persistence.*;
/**
 * Created by oleg on 05.03.16.
 */

@Entity(name = "products")
public class Product extends BaseModel {
    @ManyToOne
    private Category category;

    private String vendorCode;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private String imageLink;
//    private String imageFile;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    private Availability availability;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    private String keyWords;

    private String exCategoryID;
    private String exProductID;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

//    public String getImageFile() {
//        return imageFile;
//    }
//
//    public void setImageFile(String imageFile) {
//        this.imageFile = imageFile;
//    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getExCategoryID() {
        return exCategoryID;
    }

    public void setExCategoryID(String exCategoryID) {
        this.exCategoryID = exCategoryID;
    }

    public String getExProductID() {
        return exProductID;
    }

    public void setExProductID(String exProductID) {
        this.exProductID = exProductID;
    }

}
