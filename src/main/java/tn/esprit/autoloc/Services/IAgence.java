package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Agence;

import java.util.List;
import java.util.Set;

public interface IAgence {

    Agence ajouterAgence(Agence a);
    void supprimerAgence(long idAgence);
    List<Agence> recupererAgences();
    Set<Agence> findAgences();
    Agence recupererAgenceByid(long idAgence);
    Agence modifierAgence(Agence a);
}