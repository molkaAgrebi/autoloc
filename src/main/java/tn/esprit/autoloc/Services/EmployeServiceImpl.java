package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Repositories.AgenceRepo;
import tn.esprit.autoloc.Repositories.EmployeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {

    private final EmployeRepo employeRepo;
    private final AgenceRepo agenceRepo;

    @Override
    public Employe ajouterEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public void supprimerEmploye(long idEmploye) {
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeRepo.findAll();
    }

    @Override
    public Set<Employe> findEmployes() {
        return new HashSet<>(employeRepo.findAll());
    }

    @Override
    public Employe recupererEmployeByid(long idEmploye) {
        return employeRepo.findById(idEmploye).orElseThrow();
    }

    @Override
    public Employe modifierEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepo.findById(idEmploye).get();
        employe.setAgence(null);
        return employeRepo.save(employe);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepo.findById(idEmploye).get();
        Agence agence = agenceRepo.findById(idAgence).get();
        employe.setAgence(agence);
        return employeRepo.save(employe);
    }
}