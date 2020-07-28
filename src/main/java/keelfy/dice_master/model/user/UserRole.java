package keelfy.dice_master.model.user;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author keelfy
 */
public enum UserRole implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }
}
