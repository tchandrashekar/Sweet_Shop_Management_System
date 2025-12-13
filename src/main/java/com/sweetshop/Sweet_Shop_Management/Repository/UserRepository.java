
package com.sweetshop.Sweet_Shop_Management.Repository;

import com.sweetshop.Sweet_Shop_Management.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
