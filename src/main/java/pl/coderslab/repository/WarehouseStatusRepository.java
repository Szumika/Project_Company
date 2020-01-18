package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.WarehouseKind;
import pl.coderslab.entity.WarehouseStatus;

public interface WarehouseStatusRepository extends JpaRepository<WarehouseStatus, Long> {


}