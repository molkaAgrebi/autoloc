package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Services.IReservation;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservation iReservation;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return iReservation.ajouterReservation(reservation);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservation.modifierReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        iReservation.supprimerReservation(id);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return iReservation.recupererReservations();
    }

    @GetMapping("/getReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return iReservation.recupererReservationByid(id);
    }
}