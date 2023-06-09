package app.api.superarte.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String nombre;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_nacimiento;

    @NotEmpty
    private String telefono;

    @NotEmpty
    private String direccion;

    private String password;

    private Boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    @ManyToOne(fetch = FetchType.LAZY) // Miramos Primero La entidad que seria user y luego la que declaramos, gabinete
    @JoinColumn(name = "id_gabinete", referencedColumnName = "id")
    private Gabinete gabinete_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id.equals(users.id) && email.equals(users.email) && nombre.equals(users.nombre) && fecha_nacimiento.equals(users.fecha_nacimiento) && Objects.equals(telefono, users.telefono) && Objects.equals(direccion, users.direccion) && password.equals(users.password) && gabinete_id.equals(users.gabinete_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nombre, fecha_nacimiento, telefono, direccion, password, gabinete_id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", password='" + password + '\'' +
                ", gabinete_id=" + gabinete_id +
                '}';
    }
}
