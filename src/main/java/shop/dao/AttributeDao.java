package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Attribute;

/**
 * Created by oleg on 11.03.16.
 */
public interface AttributeDao extends JpaRepository<Attribute, Integer> {
}
