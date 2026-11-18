package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Services.IAgence;

import java.util.List;

@RestController
@Tag(name="Gestion Agence")
@RequestMapping("/api/agence")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgence iAgence;

    @Operation(description = "Ajouter un objet agence dans la BD")
    @PostMapping("/addAgence")
    public Agence addAgence(@RequestBody Agence agence) {
        return iAgence.ajouterAgence(agence);
    }

    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence agence) {
        return iAgence.modifierAgence(agence);
    }

    @DeleteMapping("/deleteAgence/{id}")
    public void deleteAgence(@PathVariable Long id) {
        iAgence.supprimerAgence(id);
    }

    @GetMapping("/getAllAgences")
    public List<Agence> getAllAgences() {
        return iAgence.recupererAgences();
    }

    @GetMapping("/getAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return iAgence.recupererAgenceByid(id);
    }
}