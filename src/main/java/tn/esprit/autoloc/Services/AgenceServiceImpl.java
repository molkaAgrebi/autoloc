package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Repositories.AgenceRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgence {

    private final AgenceRepo agenceRepo;

    @Override
    public Agence ajouterAgence(Agence a) {
        return agenceRepo.save(a);
    }

    @Override
    public void supprimerAgence(long idAgence) {
        agenceRepo.deleteById(idAgence);
    }

    @Override
    public List<Agence> recupererAgences() {
        return agenceRepo.findAll();
    }

    @Override
    public Set<Agence> findAgences() {
        return new HashSet<>(agenceRepo.findAll());
    }

    @Override
    public Agence recupererAgenceByid(long idAgence) {
        return agenceRepo.findById(idAgence).orElseThrow();
    }

    @Override
    public Agence modifierAgence(Agence a) {
        return agenceRepo.save(a);
    }
}