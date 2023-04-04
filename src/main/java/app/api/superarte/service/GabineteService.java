package app.api.superarte.service;

import app.api.superarte.model.Gabinete;

import java.util.List;
import java.util.Optional;

public interface GabineteService {

    List<Gabinete> listAllGabinetes();
    Optional<Gabinete> getGabineteById(Long id);
    Gabinete getGabineteByDireccion(String direccion);
    Gabinete createGabinete(Gabinete gabinete);
    Gabinete updateGabinete(Gabinete gabinete);
    Gabinete deleteGabinete(Long id);

}
