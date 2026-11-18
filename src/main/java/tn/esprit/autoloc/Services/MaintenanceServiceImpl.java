package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Repositories.MaintenanceRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenance {

    private final MaintenanceRepo maintenanceRepo;

    @Override
    public Maintenance ajouterMaintenance(Maintenance m) {
        return maintenanceRepo.save(m);
    }

    @Override
    public void supprimerMaintenance(long idMaintenance) {
        maintenanceRepo.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> recupererMaintenances() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Set<Maintenance> findMaintenances() {
        return new HashSet<>(maintenanceRepo.findAll());
    }

    @Override
    public Maintenance recupererMaintenanceByid(long idMaintenance) {
        return maintenanceRepo.findById(idMaintenance).orElseThrow();
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance m) {
        return maintenanceRepo.save(m);
    }
}