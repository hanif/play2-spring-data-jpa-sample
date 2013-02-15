package repositories;

import models.StockType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTypeRepository extends JpaRepository<StockType, Long> {

}
