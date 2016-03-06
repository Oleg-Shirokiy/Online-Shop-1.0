package shop.dto;

import shop.model.Availability;
import shop.model.Category;
import shop.model.Currency;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * Created by oleg on 06.03.16.
 */
public class ProductDTO {
    private int categoryID;

    private String vendorCode;
    private String name;

    private Double price;

    //    @Enumerated(EnumType.STRING)
    private String currency;

    private String imageLink;

    //    @Enumerated(EnumType.STRING)
    private String availability;
    private String vendor;

    private String description;
    private String imageLinks;
    private String keyWords;

    private String exCategoryID;
    private String exProductID;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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
