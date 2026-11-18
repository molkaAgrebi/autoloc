package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Repositories.ReservationRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepo reservationRepo;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Set<Reservation> findReservations() {
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public Reservation recupererReservationByid(long idReservation) {
        return reservationRepo.findById(idReservation).orElseThrow();
    }

    @Override
    public Reservation modifierReservation(Reservation r) {
        return reservationRepo.save(r);
    }
}