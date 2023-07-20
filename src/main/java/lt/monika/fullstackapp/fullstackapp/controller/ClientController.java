package lt.monika.fullstackapp.fullstackapp.controller;

import lt.monika.fullstackapp.fullstackapp.entity.Client;
import lt.monika.fullstackapp.fullstackapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClients(@PathVariable Long id)  {
        return clientService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) throws URISyntaxException {
        Client savedClient = clientService.save(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }
}
