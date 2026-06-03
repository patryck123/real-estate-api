package com.patryck.realestate.controller;
import com.patryck.realestate.entity.*;
import com.patryck.realestate.repository.PropertyRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/properties") @RequiredArgsConstructor
@Tag(name = "Imóveis", description = "Listagem e busca de imóveis para venda e aluguel")
public class PropertyController {
    private final PropertyRepository repo;
    @PostMapping public ResponseEntity<Property> create(@RequestBody Property p) { return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(p)); }
    @GetMapping public ResponseEntity<List<Property>> findAll() { return ResponseEntity.ok(repo.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Property> findById(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/listing/{type}") public ResponseEntity<List<Property>> byListing(@PathVariable ListingType type) { return ResponseEntity.ok(repo.findByListingType(type)); }
    @GetMapping("/type/{type}") public ResponseEntity<List<Property>> byType(@PathVariable PropertyType type) { return ResponseEntity.ok(repo.findByType(type)); }
    @GetMapping("/city/{city}") public ResponseEntity<List<Property>> byCity(@PathVariable String city) { return ResponseEntity.ok(repo.findByCity(city)); }
    @GetMapping("/price") public ResponseEntity<List<Property>> byPrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max) { return ResponseEntity.ok(repo.findByPriceRange(min, max)); }
    @GetMapping("/bedrooms/{min}") public ResponseEntity<List<Property>> byBedrooms(@PathVariable int min) { return ResponseEntity.ok(repo.findByBedroomsGreaterThanEqual(min)); }
    @PutMapping("/{id}") public ResponseEntity<Property> update(@PathVariable Long id, @RequestBody Property p) { if (!repo.existsById(id)) return ResponseEntity.notFound().build(); p.setId(id); return ResponseEntity.ok(repo.save(p)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
