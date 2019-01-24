
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
    private final static QName _FetchClients_QNAME = new QName("http://jaxws.clients.com/", "fetchClients");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.clients.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FetchClients }
     * 
     */
    public FetchClients createFetchClients() {
        return new FetchClients();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchClients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.clients.com/", name = "fetchClients")
    public JAXBElement<FetchClients> createFetchClients(FetchClients value) {
        return new JAXBElement<FetchClients>(_FetchClients_QNAME, FetchClients.class, null, value);
    }

}
