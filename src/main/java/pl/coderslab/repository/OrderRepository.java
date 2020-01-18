package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Item;
import pl.coderslab.entity.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

List<Orders> findByItemInAndCreatedIsGreaterThanEqualAndCreatedIsLessThanEqual(List<Item> items, LocalDateTime d1, LocalDateTime d2);

}