package com.patryck.realestate.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name = "properties") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Property {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String title;
    @Column(columnDefinition = "TEXT") private String description;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private PropertyType type;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private ListingType listingType;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal price;
    @Column(nullable = false) private String address;
    @Column(nullable = false) private String city;
    @Column(nullable = false) private String state;
    private Double area;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer parkingSpots;
    @Builder.Default private Boolean active = true;
    @Column(nullable = false) private String ownerContact;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
}
