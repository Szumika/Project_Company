package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {



}