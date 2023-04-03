package app.api.superarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TerapeutaPacienteId implements Serializable {

    @Column(name = "id_terapeuta")
    private Long idTerapeuta;

    @Column(name = "id_paciente")
    private Long idPaciente;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TerapeutaPacienteId)) return false;
        TerapeutaPacienteId that = (TerapeutaPacienteId) o;
        return Objects.equals(getIdTerapeuta(), that.getIdTerapeuta()) &&
                Objects.equals(getIdPaciente(), that.getIdPaciente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTerapeuta(), getIdPaciente());
    }
}