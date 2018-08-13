package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Item;
import pl.coderslab.entity.news;

import java.util.List;

public interface NewsRepository extends JpaRepository<news, Long> {

    @Query(value = "SELECT * FROM endproject.news order by created DESC limit 5;",nativeQuery = true)
    List<news> FindNews();
}