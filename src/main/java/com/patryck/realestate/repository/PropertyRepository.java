package com.patryck.realestate.repository;
import com.patryck.realestate.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByListingType(ListingType listingType);
    List<Property> findByType(PropertyType type);
    List<Property> findByCity(String city);
    List<Property> findByCityAndListingType(String city, ListingType type);
    @Query("SELECT p FROM Property p WHERE p.price BETWEEN :min AND :max AND p.active=true")
    List<Property> findByPriceRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    List<Property> findByBedroomsGreaterThanEqual(int bedrooms);
}
