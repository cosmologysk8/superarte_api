package app.api.superarte.controller;

import app.api.superarte.model.Gabinete;
import app.api.superarte.service.GabineteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gabinetes")
public class GabineteController {

    @Autowired
    GabineteService gabineteService;

    @GetMapping(value = "/listar")
    public List<Gabinete> getAllGabinetes(){
        List<Gabinete> listarGabinetes = gabineteService.listAllGabinetes();
        return listarGabinetes;
    }

    @GetMapping(value = "/{id}")
    public Gabinete getGabineteById(@PathVariable("id") Long id){
        Gabinete gabineteFoundById = gabineteService.getGabineteById(id).orElse(null);
        return gabineteFoundById;
    }

    @GetMapping(value = "/direccion/{direccion}")
    public Gabinete getGabineteByDireccion(@PathVariable("direccion") String direccion){
        Gabinete gabineteFoundById = gabineteService.getGabineteByDireccion(direccion);
        return gabineteFoundById;
    }

    @PostMapping(value = "/crear")
    public Gabinete createGabinete(@RequestBody Gabinete gabinete){
        Gabinete newGabinete = gabineteService.createGabinete(gabinete);
        return newGabinete;
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<Gabinete> updateGabinete(@PathVariable("id") Long id, @RequestBody Gabinete gabinete){
        gabinete.setId(id);
        Gabinete gabineteToUpdated = gabineteService.updateGabinete(gabinete);
        if (gabineteToUpdated == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gabineteToUpdated);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Gabinete> deleteGabinete(@PathVariable("id") Long id){
        Gabinete gabineteToDelete = gabineteService.deleteGabinete(id);
        if (gabineteToDelete == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gabineteToDelete);
    }


}
