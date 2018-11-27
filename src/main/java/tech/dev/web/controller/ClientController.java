package tech.dev.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tech.dev.entites.Client;
import tech.dev.service.ClientService;

import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String afficherClient(@RequestParam("id") Long idClient, Model model) {
        Client client = clientService.findById(idClient);
        model.addAttribute("client", client);
        return "client";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String listerClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "listeClients";
    }

    @RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
    public String removeClient(@RequestParam("id") Long idClient, Model model) {
        clientService.deleteClientByClientId(idClient);

        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "listeClients";
    }

    @RequestMapping(value = "/admin/ajouterClient", method = RequestMethod.GET)
    public String preparerAffichageAjoutClient(Model model) {
        model.addAttribute("client", new Client());
        return "creerClient";
    }

    @RequestMapping(value = "/admin/creerClient", method = RequestMethod.POST)
    public String creerClient(@ModelAttribute("client") Client client) {
        clientService.create(client);
        return "redirect:../clients";
    }

}