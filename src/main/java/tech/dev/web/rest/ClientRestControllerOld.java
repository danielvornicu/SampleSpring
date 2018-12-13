package tech.dev.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.dev.service.ClientService;
import tech.dev.to.ClientTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value= ClientRestControllerOld.REQUEST_MAPPING)
public class ClientRestControllerOld {

    public static final String REQUEST_MAPPING = "/clientsOld";

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    //1. public ResponseEntity<List<Client>> listeClients() {
    public ResponseEntity<List<ClientTO>> index() {
        //1. liste d'entites
        //List<Client> clients = clientService.findAll();
        //return clients;
        //return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

        //2.liste des TO
        List<ClientTO> clients = clientService.findAllFillTO();
        return new ResponseEntity<List<ClientTO>>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //1. public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
    public ResponseEntity<ClientTO> show(@PathVariable("id") Long id) {
        try {
            //1.with entity
            //Client client = this.clientService.findById(id);
            //client.getId();
            //return new ResponseEntity<Client>(client, HttpStatus.OK);

            //with TO
            ClientTO client = clientService.findByIdFillTO(id);

            return new ResponseEntity<ClientTO>(client, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<ClientTO>(HttpStatus.NOT_FOUND);
        }
    }

    // équivalent à @RequestMapping(value = "/clients/{clientId}", method =
    // {RequestMethod.DELETE})
    //@DeleteMapping(value = "/{id}")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    //1. public ResponseEntity<List<Client>>  delete(@PathVariable("id") Long id) {
    public ResponseEntity<List<ClientTO>> delete(@PathVariable("id") Long id) {

        clientService.deleteClientByClientId(id);

        //1.with entity
        //List<Client> clients = clientService.findAll();
        //return HttpStatus.OK;
        //return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

        //with TO
        List<ClientTO> clients = clientService.findAllFillTO();
        return new ResponseEntity<List<ClientTO>>(clients, HttpStatus.OK);
    }

    //@PostMapping(value = "/clients")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    //1. public ResponseEntity<Client> createClient(@RequestBody Client client) {
    public ResponseEntity<ClientTO> create(@RequestBody ClientTO clientTO) {
        //1. with entity
        //clientService.save(client, true);

        //2.with TO
        clientService.saveTO(clientTO, true);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public ResponseEntity<ClientTO> update(@RequestBody ClientTO clientTO) {

        clientService.saveTO(clientTO, false);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
