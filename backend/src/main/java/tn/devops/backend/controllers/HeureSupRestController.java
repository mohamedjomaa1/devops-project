package tn.devops.backend.controllers;

import tn.devops.backend.entities.HeureSup;
import tn.devops.backend.services.IHeureSupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/heure-sup")
public class HeureSupRestController {

    @Autowired
    private IHeureSupService heureSupService;

    @PostMapping("/add-heure-sup")
    public HeureSup addHeureSup(@RequestBody HeureSup heureSup) {
        return heureSupService.addHeureSup(heureSup);
    }

    @PutMapping("/update-heure-sup/{id}")
    public HeureSup updateHeureSup(@PathVariable int id, @RequestBody HeureSup heureSup) {
        return heureSupService.updateHeureSup(id, heureSup);
    }

    @DeleteMapping("/delete-heure-sup/{id}")
    public void deleteHeureSup(@PathVariable int id){
        heureSupService.deleteHeureSup(id);
    }

    @GetMapping("/get-heure-sup/{id}")
    public HeureSup getHeureSup(@PathVariable int id){
        return heureSupService.getHeureSup(id);
    }

    @GetMapping("/get-all-heures-sup")
    public Set<HeureSup> getAllHeureSup(){
        return heureSupService.getHeureSups();
    }

    @PutMapping("affect-employe-by-id/{id}")
    public HeureSup affectEmployeById(@PathVariable int id,@RequestBody HeureSup heureSup){
        return heureSupService.affectEmployeById(id, heureSup);
    }

}
