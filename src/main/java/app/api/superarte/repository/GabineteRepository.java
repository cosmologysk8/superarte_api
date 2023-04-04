package app.api.superarte.repository;

import app.api.superarte.model.Gabinete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GabineteRepository extends JpaRepository<Gabinete, Long> {
    public Gabinete findByDireccion(String direccion);
}
