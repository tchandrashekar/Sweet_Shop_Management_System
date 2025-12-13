
package com.sweetshop.Sweet_Shop_Management.Service;

import com.sweetshop.Sweet_Shop_Management.Entity.Sweet;
import com.sweetshop.Sweet_Shop_Management.Exception.ResourceNotFoundException;
import com.sweetshop.Sweet_Shop_Management.Repository.SweetRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SweetService {
    
    
    private final SweetRepository sweetRepo;

    public SweetService(SweetRepository sweetRepo) {
        this.sweetRepo = sweetRepo;
    }

    public Sweet addSweet(Sweet sweet) {
        return sweetRepo.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepo.findAll();
    }

    // SEARCH
    public List<Sweet> searchByName(String name) {
        return sweetRepo.findByNameContainingIgnoreCase(name);
    }

    public List<Sweet> searchByCategory(String category) {
        return sweetRepo.findByCategoryIgnoreCase(category);
    }

    public List<Sweet> searchByPrice(double min, double max) {
        return sweetRepo.findByPriceBetween(min, max);
    }

    // PURCHASE
    public Sweet purchaseSweet(Long id, int qty) {
        Sweet sweet = sweetRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        if (sweet.getQuantity() < qty) {
            throw new RuntimeException("Insufficient stock");
        }

        sweet.setQuantity(sweet.getQuantity() - qty);
        return sweetRepo.save(sweet);
    }

    // RESTOCK (ADMIN)
    public Sweet restockSweet(Long id, int qty) {
        Sweet sweet = sweetRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setQuantity(sweet.getQuantity() + qty);
        return sweetRepo.save(sweet);
    }
    
    public Sweet updateSweet(Long id, Sweet updatedSweet) {
        Sweet existing = sweetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sweet not found"));

        existing.setName(updatedSweet.getName());
        existing.setCategory(updatedSweet.getCategory());
        existing.setPrice(updatedSweet.getPrice());
        existing.setQuantity(updatedSweet.getQuantity());

        return sweetRepo.save(existing);
    }

  
    public void deleteSweet(Long id) {
        Sweet sweet = sweetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sweet not found"));

        sweetRepo.delete(sweet);
    }
}