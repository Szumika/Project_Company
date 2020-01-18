package pl.coderslab.dto;

import pl.coderslab.entity.Item;
import pl.coderslab.entity.Orders;
import pl.coderslab.entity.security.User;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrderDTO {
    private long id;
    @Min(value = 500,message = "Minimalne zamowienie to 200 sztuk :)")
    private int quantity;
    private LocalDateTime created;
    private String status;
    @NotNull(message = "wybierz produkt!")
    private String item;
    private User user;
    private double price;

    public OrderDTO(Orders orders) {
        this.id = orders.getId();
        this.quantity = orders.getQuantity();
        this.created = orders.getCreated();
        this.status = orders.getStatus();
        this.item = orders.getItem().getName();
        this.user = orders.getUser();
        this.price = (orders.getQuantity() * orders.getItem().getPrize());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderDTO() {
    }
}
