package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Employe;

import java.util.List;
import java.util.Set;

public interface IEmploye {

    Employe ajouterEmploye(Employe e);
    void supprimerEmploye(long idEmploye);
    List<Employe> recupererEmployes();
    Set<Employe> findEmployes();
    Employe recupererEmployeByid(long idEmploye);
    Employe modifierEmploye(Employe e);
    Employe desaffecterEmploye(Long idEmploye);
    Employe affecterEmploye(Long idEmploye, Long idAgence);
}