package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Contrat;

import java.util.List;
import java.util.Set;

public interface IContrat {

    Contrat ajouterContrat(Contrat c);
    void supprimerContrat(long idContrat);
    List<Contrat> recupererContrats();
    Set<Contrat> findContrats();
    Contrat recupererContratByid(long idContrat);
    Contrat modifierContrat(Contrat c);
}