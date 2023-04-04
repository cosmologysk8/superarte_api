package app.api.superarte.service;

import app.api.superarte.model.Gabinete;
import app.api.superarte.repository.GabineteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GabineteServiceImpl implements GabineteService{

    @Autowired
    GabineteRepository gabineteRepository;

    @Override
    public List<Gabinete> listAllGabinetes(){
        return gabineteRepository.findAll();
    }

    @Override
    public Optional<Gabinete> getGabineteById(Long id){
        return gabineteRepository.findById(id);
    }

    @Override
    public Gabinete getGabineteByDireccion(String direccion){
        return gabineteRepository.findByDireccion(direccion);
    }

    @Override
    public Gabinete createGabinete(Gabinete gabinete){
        return gabineteRepository.save(gabinete);
    }

    @Override
    public Gabinete updateGabinete(Gabinete gabinete){
        Gabinete gabineteToUpdate = getGabineteById(gabinete.getId()).orElse(null);
        if (gabineteToUpdate == null){
            return null;
        }
        gabineteToUpdate.setDireccion(gabinete.getDireccion());
        return gabineteRepository.save(gabineteToUpdate);
    }

    @Override
    public Gabinete deleteGabinete(Long id){
        Gabinete gabineteToDelete = getGabineteById(id).orElse(null);
        gabineteRepository.delete(gabineteToDelete);
        return gabineteToDelete;
    }


}
