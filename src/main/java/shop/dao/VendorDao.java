package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Vendor;

/**
 * Created by oleg on 11.03.16.
 */
public interface VendorDao extends JpaRepository<Vendor, Integer> {
}
