
package com.sweetshop.Sweet_Shop_Management.Controller;

import com.sweetshop.Sweet_Shop_Management.Entity.Sweet;
import com.sweetshop.Sweet_Shop_Management.Service.SweetService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sweets")
public class SweetController {
    
    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

     // ADD SWEET
    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    // GET ALL
    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    // SEARCH
    @GetMapping("/search")
    public List<Sweet> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        if (name != null) {
            return sweetService.searchByName(name);
        }
        if (category != null) {
            return sweetService.searchByCategory(category);
        }
        if (minPrice != null && maxPrice != null) {
            return sweetService.searchByPrice(minPrice, maxPrice);
        }
        return sweetService.getAllSweets();
    }

    // PURCHASE
    @PostMapping("/{id}/purchase")
    public Sweet purchase(@PathVariable Long id, @RequestParam int qty) {
        return sweetService.purchaseSweet(id, qty);
    }

    // RESTOCK (ADMIN)
    @PostMapping("/{id}/restock")
    public Sweet restock(@PathVariable Long id, @RequestParam int qty) {
        return sweetService.restockSweet(id, qty);
    }
    
      @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Sweet> updateSweet(
            @PathVariable Long id,
            @Valid @RequestBody Sweet updatedSweet
    ) {
        return ResponseEntity.ok(
                sweetService.updateSweet(id, updatedSweet)
        );
    }

    /* ========================= DELETE SWEET ========================= */
    // Admin only
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.ok("Sweet deleted successfully");
    }
}