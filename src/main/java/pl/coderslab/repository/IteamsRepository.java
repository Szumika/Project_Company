package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Item;
import pl.coderslab.entity.security.User;

public interface IteamsRepository extends JpaRepository<Item, Long> {
Item findByNameContaining(String name);
}