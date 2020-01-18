package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Warehouse;
import pl.coderslab.entity.WarehouseKind;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

List<Warehouse> findByWarehouseKind(WarehouseKind warehouseKind);
List<Warehouse> findByNameContaining(String s);
}