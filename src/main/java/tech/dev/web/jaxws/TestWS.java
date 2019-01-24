package tech.dev.web.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Description de la classe
 * <p>
 * Date: 18/12/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@WebService(name="TestWebServ", portName= "TestWebServicePort", serviceName = "TestWebService",
        targetNamespace = "http://jaxws.test.com/"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT) //RPC(simple string response) ou DOCUMENT(default)
public class TestWS {

    @WebMethod
    @WebResult(partName = "lookupOutput")
    //default is arg0 in part name, replace with lookupInput
    public String getInfo(@WebParam(partName = "lookupInput") String arg ){
        String response = "Invalid arg";
        if ("1".equals(arg)){
            response = "arg 1";
        }
        else if ("2".equals(arg)){
            response = "arg 2";
        }
        return response;
    }
}
