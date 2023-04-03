package app.api.superarte.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "gabinete")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Gabinete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion")
    @NotNull
    private String direccion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gabinete gabinete = (Gabinete) o;
        return id.equals(gabinete.id) && direccion.equals(gabinete.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direccion);
    }

    @Override
    public String toString() {
        return "Gabinete{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
