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
@Table(name = "paciente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "observaciones")
    private String observacion;

    @OneToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    private Users user_id;

    @OneToOne
    @JoinColumn(name = "id_gabinete", referencedColumnName = "id")
    private Gabinete gabinete_id;

    @ManyToMany(mappedBy = "pacientes")
    private Set<Terapeuta> terapeutas = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return id.equals(paciente.id) && Objects.equals(observacion, paciente.observacion) && user_id.equals(paciente.user_id) && gabinete_id.equals(paciente.gabinete_id) && terapeutas.equals(paciente.terapeutas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, observacion, user_id, gabinete_id, terapeutas);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", user_id=" + user_id +
                ", gabinete_id=" + gabinete_id +
                ", terapeutas=" + terapeutas +
                '}';
    }
}
