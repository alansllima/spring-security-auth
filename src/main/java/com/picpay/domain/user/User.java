package com.picpay.domain.user;





import com.picpay.domain.transaction.Transaction;
import com.picpay.exception.ResourceNotFoundException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity(name ="users")
@Table(name = "users")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String login;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private UserRole role;
    @ManyToMany
    @JoinTable(name = "user_transaction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private Set<Transaction> transactions = new HashSet<>();

    public User(String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.userType = userType;
    }

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
