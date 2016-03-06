package shop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
@Entity(name = "orders")
public class Order extends BaseModel{
    @OneToMany
    private List<Product> productList;

    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String message;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
