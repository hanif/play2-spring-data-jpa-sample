package repositories;

import models.StockPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPurchaseRepository extends JpaRepository<StockPurchase, Long> {

}
