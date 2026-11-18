package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Equipement;

import java.util.List;
import java.util.Set;

public interface IEquipement {

    Equipement ajouterEquipement(Equipement e);
    void supprimerEquipement(long idEquipement);
    List<Equipement> recupererEquipements();
    Set<Equipement> findEquipements();
    Equipement recupererEquipementByid(long idEquipement);
    Equipement modifierEquipement(Equipement e);
}