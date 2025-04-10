package tn.devops.backend.services;

import tn.devops.backend.entities.Employe;
import tn.devops.backend.repositories.EmployeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeServiceImpl implements IEmployeService{

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(int id, Employe employe) {
        return employeRepository.findById(id).isPresent() ? employeRepository.save(employe) : null;
    }

    @Override
    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getEmploye(int id) {
        return employeRepository.findById(id).isPresent() ? employeRepository.findById(id).get() : null;
    }

    @Override
    public Set<Employe> getEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }
}
