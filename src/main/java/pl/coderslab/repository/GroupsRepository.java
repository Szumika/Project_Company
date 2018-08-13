package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.groups;


public interface GroupsRepository extends JpaRepository<groups, Long> {


}