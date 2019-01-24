
package tech.dev.web.jaxws.sei;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.clients.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FetchClientsResponse_QNAME = new QName("http://jaxws.clients.com/", "fetchClientsResponse");
    private final static QName _DeleteClientByIdResponse_QNAME = new QName("http://jaxws.clients.com/", "deleteClientByIdResponse");
    private final static QName _FetchClientById_QNAME = new QName("http://jaxws.clients.com/", "fetchClientById");
    private final static QName _DeleteClientById_QNAME = new QName("http://jaxws.clients.com/", "deleteClientById");
    private final static QName _FetchClients_QNAME = new QName("http://jaxws.clients.com/", "fetchClients");
    private final static QName _FetchClientByIdResponse_QNAME = new QName("http://jaxws.clients.com/", "fetchClientByIdResponse");
    private final static QName _SaveClientResponse_QNAME = new QName("http://jaxws.clients.com/", "saveClientResponse");
    private final static QName _SaveClient_QNAME = new QName("http://jaxws.clients.com/", "saveClient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.clients.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveClient }
     * 
     */
    public SaveClient createSaveClient() {
        return new SaveClient();
    }

    /**
     * Create an instance of {@link SaveClientResponse }
     * 
     */
    public SaveClientResponse createSaveClientResponse() {
        return new SaveClientResponse();
    }

    /**
     * Create an instance of {@link FetchClientByIdResponse }
     * 
     */
    public FetchClientByIdResponse createFetchClientByIdResponse() {
        return new FetchClientByIdResponse();
    }

    /**
     * Create an instance of {@link FetchClientById }
     * 
     */
    public FetchClientById createFetchClientById() {
        return new FetchClientById();
    }

    /**
     * Create an instance of {@link DeleteClientByIdResponse }
     * 
     */
    public DeleteClientByIdResponse createDeleteClientByIdResponse() {
        return new DeleteClientByIdResponse();
    }

    /**
     * Create an instance of {@link FetchClients }
     * 
     */
    public FetchClients createFetchClients() {
        return new FetchClients();
    }

    /**
     * Create an instance of {@link DeleteClientById }
     * 
     */
    public DeleteClientById createDeleteClientById() {
        return new DeleteClientById();
    }

    /**
     * Create an instance of {@link FetchClientsResponse }
     * 
     */
    public FetchClientsResponse createFetchClientsResponse() {
        return new FetchClientsResponse();
    }

    /**
     * Create an instance of {@link ClientTO }
     * 
     */
    public ClientTO createClientTO() {
        return new ClientTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchClientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "fetchClientsResponse")
    public JAXBElement<FetchClientsResponse> createFetchClientsResponse(FetchClientsResponse value) {
        return new JAXBElement<FetchClientsResponse>(_FetchClientsResponse_QNAME, FetchClientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClientByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "deleteClientByIdResponse")
    public JAXBElement<DeleteClientByIdResponse> createDeleteClientByIdResponse(DeleteClientByIdResponse value) {
        return new JAXBElement<DeleteClientByIdResponse>(_DeleteClientByIdResponse_QNAME, DeleteClientByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchClientById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "fetchClientById")
    public JAXBElement<FetchClientById> createFetchClientById(FetchClientById value) {
        return new JAXBElement<FetchClientById>(_FetchClientById_QNAME, FetchClientById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClientById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "deleteClientById")
    public JAXBElement<DeleteClientById> createDeleteClientById(DeleteClientById value) {
        return new JAXBElement<DeleteClientById>(_DeleteClientById_QNAME, DeleteClientById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchClients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "fetchClients")
    public JAXBElement<FetchClients> createFetchClients(FetchClients value) {
        return new JAXBElement<FetchClients>(_FetchClients_QNAME, FetchClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchClientByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "fetchClientByIdResponse")
    public JAXBElement<FetchClientByIdResponse> createFetchClientByIdResponse(FetchClientByIdResponse value) {
        return new JAXBElement<FetchClientByIdResponse>(_FetchClientByIdResponse_QNAME, FetchClientByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "saveClientResponse")
    public JAXBElement<SaveClientResponse> createSaveClientResponse(SaveClientResponse value) {
        return new JAXBElement<SaveClientResponse>(_SaveClientResponse_QNAME, SaveClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "saveClient")
    public JAXBElement<SaveClient> createSaveClient(SaveClient value) {
        return new JAXBElement<SaveClient>(_SaveClient_QNAME, SaveClient.class, null, value);
    }

}
