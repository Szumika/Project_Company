package pl.coderslab.entity;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.dto.OrderDTO;
import pl.coderslab.entity.security.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Min(50)
private int quantity;
private LocalDateTime created;
private String status;
@NotNull(message = "wybierz produkt!")
@OneToOne
private Item item;
@OneToOne
private User user;
    public Orders() {
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
