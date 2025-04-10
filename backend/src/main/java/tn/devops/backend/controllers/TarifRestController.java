package tn.devops.backend.controllers;


import tn.devops.backend.entities.Tarif;
import tn.devops.backend.services.ITarifService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/tarif")
public class TarifRestController {

    @Autowired
    private ITarifService tarifService;

    @PostMapping("/add-tarif")
    public Tarif addTarif(@RequestBody Tarif tarif) {
        return tarifService.addTarif(tarif);
    }

    @PutMapping("/update-tarif/{id}")
    public Tarif updateTarif(@PathVariable int id, @RequestBody Tarif tarif) {
        return tarifService.updateTarif(id, tarif);
    }

    @DeleteMapping("/delete-tarif/{id}")
    public void deleteTarif(@PathVariable int id){
        tarifService.deleteTarif(id);
    }

    @GetMapping("/get-tarif/{id}")
    public Tarif getTarif(@PathVariable int id){
        return tarifService.getTarif(id);
    }

    @GetMapping("/get-all-tarifs")
    public Set<Tarif> getAllHeureSup(){
        return tarifService.getTarifs();
    }
}
