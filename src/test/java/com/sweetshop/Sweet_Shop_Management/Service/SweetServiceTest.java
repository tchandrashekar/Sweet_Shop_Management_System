
package com.sweetshop.Sweet_Shop_Management.Service;

import com.sweetshop.Sweet_Shop_Management.Entity.Sweet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SweetServiceTest {

    @Autowired
    SweetService sweetService;

    @Test
    void testPurchaseSweet() {
        Sweet sweet = new Sweet();
        sweet.setName("Ladoo");
        sweet.setQuantity(10);

        Sweet saved = sweetService.addSweet(sweet);
        Sweet updated = sweetService.purchaseSweet(saved.getId(), 2);

        assertEquals(8, updated.getQuantity());
    }
    
    @Test
void testSearchByName() {
    Sweet s = new Sweet();
    s.setName("Gulab Jamun");
    s.setCategory("Indian");
    s.setPrice(10);
    s.setQuantity(20);

    sweetService.addSweet(s);

    List<Sweet> result = sweetService.searchByName("gulab");

    assertFalse(result.isEmpty());
}

}
