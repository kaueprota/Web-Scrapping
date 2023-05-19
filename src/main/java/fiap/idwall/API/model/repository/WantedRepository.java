package fiap.idwall.API.model.repository;

import fiap.idwall.API.model.Wanted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WantedRepository extends JpaRepository<Wanted, Long> {

    @Query(value =  "SELECT * FROM wanted wa " +
                    "WHERE wa.name LIKE CONCAT( :param, '%') ",nativeQuery = true)
    List<Wanted> findByName(String param);

}
