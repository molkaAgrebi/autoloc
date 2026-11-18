package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Repositories.PaiementRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiement {

    private final PaiementRepo paiementRepo;

    @Override
    public Paiement ajouterPaiement(Paiement p) {
        return paiementRepo.save(p);
    }

    @Override
    public void supprimerPaiement(long idPaiement) {
        paiementRepo.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> recupererPaiements() {
        return paiementRepo.findAll();
    }

    @Override
    public Set<Paiement> findPaiements() {
        return new HashSet<>(paiementRepo.findAll());
    }

    @Override
    public Paiement recupererPaiementByid(long idPaiement) {
        return paiementRepo.findById(idPaiement).orElseThrow();
    }

    @Override
    public Paiement modifierPaiement(Paiement p) {
        return paiementRepo.save(p);
    }
}