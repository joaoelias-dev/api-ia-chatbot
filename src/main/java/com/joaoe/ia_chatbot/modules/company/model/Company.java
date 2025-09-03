package com.joaoe.ia_chatbot.modules.company.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "brand_name")
    @NotBlank(message = "The company must have at least a brand name")
    private String brandName;

    @Column(name = "legal_name")
    @NotBlank(message = "The company must have at least a legal name")
    private String legalName;

    @Column(name = "taxId")
    private String taxId; // CNPJ, EIN, VAT, etc.

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CompanyPhone> phones;

    @Column(name = "website")
    private String website;

    @Column(name = "currency")
    private String currency;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "deleted")
    private boolean deleted;
    
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
    
}
