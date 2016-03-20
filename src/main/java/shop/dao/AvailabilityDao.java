package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Availability;

/**
 * Created by oleg on 11.03.16.
 */
public interface AvailabilityDao extends JpaRepository<Availability, Integer> {
}
