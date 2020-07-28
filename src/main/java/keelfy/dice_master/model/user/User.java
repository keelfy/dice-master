package keelfy.dice_master.model.user;

import keelfy.dice_master.model.Game;
import keelfy.dice_master.model.character.GameCharacter;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Describes website user.
 *
 * @author keelfy
 */
@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "username"})
@ToString(of = {"id", "username", "createdAt", "roles", "active"})
public class User implements UserDetails  {

    @Id
    @GeneratedValue
    private Long id;
    /** User's display name. */
    private String username;
    /** His password. */
    private String password;
    /** Time when account was created. */
    private DateTime createdAt;
    /** Whether is user currently active. */
    private boolean active;

    /**
     * Stores list of user's roles into `user_role` table.
     * */
    @ElementCollection(
            targetClass = UserRole.class,
            fetch = FetchType.EAGER
    )
    @CollectionTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    /**
     * Stores collection of user's games mapped by {@link Game#getUsers()}.
     * */
    @ManyToMany(
            mappedBy = "users",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.LAZY
    )
    private Set<Game> games = new HashSet<>();

    /**
     * Stores collection of user's characters.
     * */
    @OneToMany(
            mappedBy = "owner",
            cascade = { CascadeType.ALL },
            orphanRemoval = true
    )
    private Set<GameCharacter> characters = new HashSet<>();

    /**
     * @return whether this player has {@link UserRole#ADMIN}.
     * */
    public boolean isAdmin() {
        return this.roles.contains(UserRole.ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
