package shop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.model.Product;
import javax.persistence.criteria.*;

import java.util.List;

/**
 * Created by oleg on 05.03.16.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("select p from products p where p.id in :idList")
    List<Product> findByIdList(@Param("idList") List<Integer> idList);

    @Query("select p from products p where p.vendorCode = :code")
    public List<Product> findByCode(@Param("code") String vendorCode);

//    @Query("select p from products p where p.name like concat('%', :name, '%')")
//    public Page<Product> findByName(Pageable pageable, @Param("name") String name);
//
//    @Query("select p from products p where p.name like concat('%', :name, '%') order by p.price asc")
//    public Page<Product> findByNameOrderByPriceAsc(Pageable pageable, @Param("name") String name);
//
//    @Query("select p from products p where p.name like concat('%', :name, '%') order by p.price desc")
//    public Page<Product> findByNameOrderByPriceDesc(Pageable pageable, @Param("name") String name);

    @Query("select p from products p where p.name like concat('%', :name, '%') and " +
    "p.category.id = :categoryID and p.vendor.name like :vendor and p.availability.status like :avail and " +
    "p.price between :minPrice and :maxPrice")
    public Page<Product> findByFilter(Pageable pageable,
                                      @Param("name") String name,
                                      @Param("categoryID") Integer categoryID,
                                      @Param("vendor") String vendor,
                                      @Param("avail") String availability,
                                      @Param("minPrice") Double minPrice,
                                      @Param("maxPrice") Double maxPrise);

    @Query("select p from products p where p.name like concat('%', :name, '%') and " +
            "p.vendor.name like :vendor and p.availability.status like :avail and " +
            "p.price between :minPrice and :maxPrice")
    Page<Product> findByFilter(Pageable pageable,
                                      @Param("name") String name,
                                      @Param("vendor") String vendor,
                                      @Param("avail") String availability,
                                      @Param("minPrice") Double minPrice,
                                      @Param("maxPrice") Double maxPrise);

    @Query("select p from products p where p.name like concat('%', :name, '%') and " +
            "p.category.id = :categoryID and p.availability.status like :avail and " +
            "p.price between :minPrice and :maxPrice")
    public Page<Product> findByFilter(Pageable pageable,
                                      @Param("name") String name,
                                      @Param("categoryID") Integer categoryID,
                                      @Param("avail") String availability,
                                      @Param("minPrice") Double minPrice,
                                      @Param("maxPrice") Double maxPrise);

    @Query("select p from products p where p.name like concat('%', :name, '%') and " +
            "p.availability.status like :avail and " +
            "p.price between :minPrice and :maxPrice")
    public Page<Product> findByFilter(Pageable pageable,
                                      @Param("name") String name,
                                      @Param("avail") String availability,
                                      @Param("minPrice") Double minPrice,
                                      @Param("maxPrice") Double maxPrise);


}



