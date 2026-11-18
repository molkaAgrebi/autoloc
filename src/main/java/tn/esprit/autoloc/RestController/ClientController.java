package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Services.IClient;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final IClient iClient;

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return iClient.ajouterClient(client);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return iClient.modifierClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClient.supprimerClient(id);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return iClient.recupererClients();
    }

    @GetMapping("/getClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return iClient.recupererClientByid(id);
    }
}

