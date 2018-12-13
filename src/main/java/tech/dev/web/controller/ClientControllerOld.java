package tech.dev.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.dev.service.ClientService;
import tech.dev.to.ClientTO;
import tech.dev.web.formulaires.ClientForm;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(ClientControllerOld.REQUEST_MAPPING)
@SessionAttributes({
        ClientControllerOld.CLIENT_FORM
})
public class ClientControllerOld{

    public static final String REQUEST_MAPPING = "/clientOld";
    public static final String CLIENT_FORM = "clientForm";
    public static final String CLIENTS_LISTE = "listeClients";

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        //liste d'entites
        //List<Client> clients = clientService.findAll();

        //liste des TO
        List<ClientTO> clients = clientService.findAllFillTO();

        //1. model.addAttribute(CLIENTS_LISTE, clients); model de type Model
        //1. return "clientsListe";

        //2. model.put(CLIENTS_LISTE, clients); model de type ModelMap
        //2. return "clientsListe"; model de type ModelMap

        //3. model.addObject(CLIENTS_LISTE, clients); model de type ModelAndView
        //3. model.setViewName("clientsListe"); model de type ModelAndView
        //3. return model; model de type ModelAndView

        model.put(CLIENTS_LISTE, clients);
        return "clientListe";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, ModelMap model) {
        //with entity
        //Client client = clientService.findById(id);
        //with TO
        ClientTO client = clientService.findByIdFillTO(id);

        model.put("client", client);

        return "clientConsult";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    //1. public String edit(@PathVariable Long id,  ModelMap model) {
    public String edit(@PathVariable Long id, ClientForm form, ModelMap model) {
        //with entity
        //Client client = clientService.findById(id);

        //1. with TO
        //ClientTO client = clientService.findByIdFillTO(id);
        //model.put("client", client);

        //with Form(for insert, update only) and TO
        ClientTO client = clientService.findByIdFillTO(id);
        fillModel(form, model, client);

        return "clientFiche";
    }


    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    //1.public String update(@PathVariable Long id, @ModelAttribute("client") Client client) {
    //2.public String update(@PathVariable Long id, @ModelAttribute("client") ClientTO clientTO) {
    public String update(@PathVariable Long id, @Valid ClientForm form) {
        //1.with entity
        //clientService.save(client, false);

        //2.with TO
        //clientService.saveTO(clientTO,false);

        //3.with Form(for insert, update only) and TO
        ClientTO clientTO = form.saveForm();
        clientService.saveTO(clientTO, false);

        return "redirect:../.." + REQUEST_MAPPING;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, ModelMap model) {
        clientService.deleteClientByClientId(id);

        //with entity
        //List<Client> clients = clientService.findAll();

        //with TO
        List<ClientTO> clients = clientService.findAllFillTO();

        model.put(CLIENTS_LISTE, clients);

        return "redirect:../.." + REQUEST_MAPPING;
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newObject(ModelMap model) {

        //with entity
        //model.put("client", new Client());

        //with TO
        //model.put("client", new ClientTO());

        //with Form(for insert, update only) and TO
        fillModel(new ClientForm(), model, new ClientTO());

        return "clientFiche";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    //1.public String create(@ModelAttribute("client") Client client) {
    //2.public String create(@ModelAttribute("client") ClientTO clientTO) {
    public String create(@Valid ClientForm form) {
        //1.with entity
        //clientService.save(client, true);

        //2.with TO
        //clientService.saveTO(clientTO, true);

        //3.with Form(for insert, update only) and TO
        ClientTO clientTO = form.saveForm();
        clientService.saveTO(clientTO, true);

        return "redirect:.." + REQUEST_MAPPING;
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(@ModelAttribute("client") ClientTO clientTO) {
        return "redirect:.." + REQUEST_MAPPING;
    }

    private void fillModel(ClientForm form, ModelMap model, ClientTO to) {
        form.initForm(to);
        model.put(CLIENT_FORM, form);
    }

}