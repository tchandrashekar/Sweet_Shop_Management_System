
package com.sweetshop.Sweet_Shop_Management.Repository;

import com.sweetshop.Sweet_Shop_Management.Entity.Sweet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SweetRepository extends JpaRepository<Sweet,Long>{
      // Search by name
    List<Sweet> findByNameContainingIgnoreCase(String name);

    // Search by category
    List<Sweet> findByCategoryIgnoreCase(String category);

    // Search by price range
    List<Sweet> findByPriceBetween(double min, double max);

}
