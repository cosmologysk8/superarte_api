package app.api.superarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Role {

    @Id
    private Long id;

    @Column(name = "role_user")
    private RolesEnum roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) && roles == role.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roles);
    }
}
