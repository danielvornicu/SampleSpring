package tech.dev.web.jaxws;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dev.to.ClientTO;
import tech.dev.web.common.base.AbstractSearchEditController;
import tech.dev.web.formulaires.ClientForm;
import tech.dev.web.jaxws.sei.ClientWebServ;
import tech.dev.web.jaxws.sei.ClientWebService;

import javax.validation.Valid;
import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 23/01/2019
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Controller
@RequestMapping(ClientSoapController.REQUEST_MAPPING)
@SessionAttributes({
        ClientSoapController.CLIENT_FORM
})
public class ClientSoapController extends AbstractSearchEditController<ClientTO, ClientForm> {

    public static final String REQUEST_MAPPING = "/wsclient";
    //vues dans le repertoire wspages
    private static final String ROOT_VUE = "wspages/wsclient";

    public static final String CLIENT= "client";
    public static final String CLIENT_FORM = "clientForm";
    public static final String CLIENTS_LISTE = "listeClients";

    @Override
    protected String getRootView() {
        return ROOT_VUE;
    }

    @Override
    protected void initializeIndexTO(ModelMap model) {
        //liste des TO
        //List<ClientTO> clients = clientService.findAllFillTO();

        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

        List<tech.dev.web.jaxws.sei.ClientTO> clients = servicePort.fetchClients();

        model.put(CLIENTS_LISTE, clients);
    }

    @Override
    protected void initializeShowTO(Long id, ClientForm form, ModelMap model) {
        //ClientTO client = clientService.findByIdFillTO(id);

        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

        tech.dev.web.jaxws.sei.ClientTO client = servicePort.fetchClientById(id);
        model.put(CLIENT, client);
    }

    @Override
    protected void initializeNewTO(ClientForm form, ModelMap model) {
        fillModel(form, model, null);
    }

    @Override
    protected void initializeEditTO(Long id, ClientForm form, ModelMap model) {
        try {
            //ClientTO client = clientService.findByIdFillTO(id);

            ClientWebService service = new ClientWebService() ;
            //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
            ClientWebServ servicePort = service.getClientWebServicePort();

            tech.dev.web.jaxws.sei.ClientTO client = servicePort.fetchClientById(id);

            //clientTO web service -> clientTO clasique
            ClientTO clientTO =  new ClientTO();
            clientTO.setId(client.getId());
            clientTO.setPrenom(client.getPrenom());
            clientTO.setNom(client.getNom());

            fillModel(form, model, clientTO);
        } catch (Exception e) {
        }
    }

    private void fillModel(ClientForm form, ModelMap model, ClientTO to) {
        form.initForm(to);
        model.put(CLIENT_FORM, form);
    }

    @Override
    protected boolean saveTO(ClientTO to, ModelMap model, boolean isCreation) {
        //clientService.saveTO(to, isCreation);

        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

        tech.dev.web.jaxws.sei.ClientTO clientTO =  new tech.dev.web.jaxws.sei.ClientTO();
        clientTO.setId(to.getId());
        clientTO.setPrenom(to.getPrenom());
        clientTO.setNom(to.getNom());

        servicePort.saveClient(clientTO, isCreation);

        return true;
    }

    @Override
    protected void deleteTO(Long id, ModelMap model) {
        //clientService.deleteClientByClientId(id);

        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

        servicePort.deleteClientById(id);
    }

    //override necessaire que pour la partie WS Soap pour gerer le sous repertoire wspages
    @Override
    public String cancel(ClientTO to) {
        return "redirect:.." + REQUEST_MAPPING;
    }

    //override necessaire que pour la partie WS Soap pour gerer le sous repertoire wspages
    @Override
    public String update(@PathVariable Long id, @Valid ClientForm form, ModelMap model) {
        ClientTO to = form.saveForm();
        saveTO(to, model, false);

        return "redirect:../.." + REQUEST_MAPPING;
    }

    //override necessaire que pour la partie WS Soap pour gerer le sous repertoire wspages
    @Override
    public String delete(@PathVariable Long id, ModelMap model) {
        deleteTO(id, model);
        return "redirect:../.." + REQUEST_MAPPING;
    }

    //override necessaire que pour la partie WS Soap pour gerer le sous repertoire wspages
    @Override
    public String create(@Valid ClientForm form, ModelMap model) {
        ClientTO to = form.saveForm();
        saveTO(to, model, true);

        return "redirect:.."  + REQUEST_MAPPING;
    }
}
