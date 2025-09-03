package com.joaoe.ia_chatbot.modules.user.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "username", unique = true)
    @NotBlank(message = "Field 'username' is required")
    @Size(min = 3, message = "Username should not be less than 3")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "Field 'password' is required")
    @Size(min = 6, message = "Password should not be less than 6")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "created_at")
    private Instant createAt;

    @Column(name = "updated_at")
    private Instant updateAt;
}
