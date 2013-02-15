package repositories;

import models.StockCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockCategoryRepository extends JpaRepository<StockCategory, Long> {

}
