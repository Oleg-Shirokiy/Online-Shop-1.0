package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Currency;

/**
 * Created by oleg on 11.03.16.
 */
public interface CurrencyDao extends JpaRepository<Currency, Integer> {
}
