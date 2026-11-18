package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Services.IContrat;

import java.util.List;

@RestController
@RequestMapping("/api/contrat")
@RequiredArgsConstructor
public class ContratController {

    private final IContrat iContrat;

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return iContrat.ajouterContrat(contrat);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return iContrat.modifierContrat(contrat);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable Long id) {
        iContrat.supprimerContrat(id);
    }

    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrats() {
        return iContrat.recupererContrats();
    }

    @GetMapping("/getContratById/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return iContrat.recupererContratByid(id);
    }
}