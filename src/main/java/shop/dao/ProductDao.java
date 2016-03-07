package shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.model.Product;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("select p from products p where p.id in :idList")
    List<Product> findByIdList(@Param("idList") List<Integer> idList);
}
