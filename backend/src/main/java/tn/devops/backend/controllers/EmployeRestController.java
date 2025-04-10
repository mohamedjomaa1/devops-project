package tn.devops.backend.controllers;

import tn.devops.backend.entities.Employe;
import tn.devops.backend.services.IEmployeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employe")
public class EmployeRestController {
    @Autowired
    private IEmployeService employeService;

    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe){
        return employeService.addEmploye(employe);
    }

    @PutMapping("/update-employe/{id}")
    public Employe updateEmploye(@PathVariable int id, @RequestBody Employe employe){
        return employeService.updateEmploye(id, employe);
    }

    @DeleteMapping("/delete-employe/{id}")
    public void deleteEmploye(@PathVariable int id){
        employeService.deleteEmploye(id);
    }

    @GetMapping("/get-employe/{id}")
    public Employe getEmploye(@PathVariable int id){
        return employeService.getEmploye(id);
    }

    @GetMapping("/get-all-employes")
    public Set<Employe> getAllEmployes(){
        return employeService.getEmployes();
    }
}
