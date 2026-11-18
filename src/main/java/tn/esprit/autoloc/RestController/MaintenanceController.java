package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Services.IMaintenance;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenance iMaintenance;

    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return iMaintenance.ajouterMaintenance(maintenance);
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return iMaintenance.modifierMaintenance(maintenance);
    }

    @DeleteMapping("/deleteMaintenance/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        iMaintenance.supprimerMaintenance(id);
    }

    @GetMapping("/getAllMaintenances")
    public List<Maintenance> getAllMaintenances() {
        return iMaintenance.recupererMaintenances();
    }

    @GetMapping("/getMaintenanceById/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return iMaintenance.recupererMaintenanceByid(id);
    }
}