package app.api.superarte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "terapeuta")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Terapeuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especialidad;

    @OneToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    private Users user_id;

    @ManyToOne
    @JoinColumn(name = "id_gabinete", referencedColumnName = "id")
    private Gabinete gabinete_id;

    @ManyToMany
    @JoinTable(
            name = "terapeuta_paciente",
            joinColumns = @JoinColumn(name = "id_terapeuta"),
            inverseJoinColumns = @JoinColumn(name = "id_pacientes")
    )
    private Set<Paciente> pacientes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terapeuta terapeuta = (Terapeuta) o;
        return id.equals(terapeuta.id) && especialidad.equals(terapeuta.especialidad) && user_id.equals(terapeuta.user_id) && gabinete_id.equals(terapeuta.gabinete_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, especialidad, user_id, gabinete_id);
    }

    @Override
    public String toString() {
        return "Terapeuta{" +
                "id=" + id +
                ", especialidad='" + especialidad + '\'' +
                ", user_id=" + user_id +
                ", gabinete_id=" + gabinete_id +
                '}';
    }
}
