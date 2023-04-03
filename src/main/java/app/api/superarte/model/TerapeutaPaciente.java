package app.api.superarte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "terapeuta_paciente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TerapeutaPaciente {

    @EmbeddedId
    private TerapeutaPacienteId id;

    @ManyToOne
    @MapsId("idTerapeuta")
    @JoinColumn(name = "id_terapeuta")
    private Terapeuta terapeuta;

    @ManyToOne
    @MapsId("idPaciente")
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerapeutaPaciente that = (TerapeutaPaciente) o;
        return id.equals(that.id) && terapeuta.equals(that.terapeuta) && paciente.equals(that.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, terapeuta, paciente);
    }

    @Override
    public String toString() {
        return "TerapeutaPaciente{" +
                "id=" + id +
                ", terapeuta=" + terapeuta +
                ", paciente=" + paciente +
                '}';
    }
}
