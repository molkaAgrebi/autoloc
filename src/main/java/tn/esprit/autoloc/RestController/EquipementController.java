package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Services.IEquipement;

import java.util.List;

@RestController
@RequestMapping("/api/equipement")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipement iEquipement;

    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return iEquipement.ajouterEquipement(equipement);
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return iEquipement.modifierEquipement(equipement);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable Long id) {
        iEquipement.supprimerEquipement(id);
    }

    @GetMapping("/getAllEquipements")
    public List<Equipement> getAllEquipements() {
        return iEquipement.recupererEquipements();
    }

    @GetMapping("/getEquipementById/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return iEquipement.recupererEquipementByid(id);
    }
}