package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Services.IEmploye;

import java.util.List;

@RestController
@RequestMapping("/api/employe")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmploye iEmploye;

    @PostMapping("/addEmploye")
    public Employe addEmploye(@RequestBody Employe employe) {
        return iEmploye.ajouterEmploye(employe);
    }

    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return iEmploye.modifierEmploye(employe);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        iEmploye.supprimerEmploye(id);
    }

    @GetMapping("/getAllEmployes")
    public List<Employe> getAllEmployes() {
        return iEmploye.recupererEmployes();
    }

    @GetMapping("/getEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return iEmploye.recupererEmployeByid(id);
    }

    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return iEmploye.desaffecterEmploye(idEmploye);
    }

    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return iEmploye.affecterEmploye(idEmploye, idAgence);
    }
}