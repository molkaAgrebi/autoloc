package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Services.IPaiement;

import java.util.List;

@RestController
@RequestMapping("/api/paiement")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiement iPaiement;

    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return iPaiement.ajouterPaiement(paiement);
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return iPaiement.modifierPaiement(paiement);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void deletePaiement(@PathVariable Long id) {
        iPaiement.supprimerPaiement(id);
    }

    @GetMapping("/getAllPaiements")
    public List<Paiement> getAllPaiements() {
        return iPaiement.recupererPaiements();
    }

    @GetMapping("/getPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return iPaiement.recupererPaiementByid(id);
    }
}