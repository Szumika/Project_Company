package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Warehouse;
import pl.coderslab.entity.WarehouseKind;

import java.util.List;

public interface WarehouseKindRepository extends JpaRepository<WarehouseKind, Long> {
WarehouseKind findByName(String name);

}