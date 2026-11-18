package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repositories.AgenceRepo;
import tn.esprit.autoloc.Repositories.EquipementRepo;
import tn.esprit.autoloc.Repositories.VehiculeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {

    private final VehiculeRepo vehiculeRepo;
    private final AgenceRepo agenceRepo;
    private final EquipementRepo equipementRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public void supprimerVehicule(long idVehicule) {
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> recupererVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Set<Vehicule> findVehicules() {
        return new HashSet<>(vehiculeRepo.findAll());
    }

    @Override
    public Vehicule recupererVehiculeByid(long idVehicule) {
        return vehiculeRepo.findById(idVehicule).orElseThrow();
    }

    @Override
    public Vehicule modifierVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule).get();
        Agence agence = agenceRepo.findById(idAgence).get();
        vehicule.setAgence(agence);
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule).get();
        Equipement equipement = equipementRepo.findById(idEquipement).get();
        vehicule.getEquipements().add(equipement);
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule).get();
        Equipement equipement = equipementRepo.findById(idEquipement).get();
        vehicule.getEquipements().remove(equipement);
        return vehiculeRepo.save(vehicule);
    }
}