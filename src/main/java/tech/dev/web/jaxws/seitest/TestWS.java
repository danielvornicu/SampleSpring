
package tech.dev.web.jaxws.seitest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TestWS", targetNamespace = "http://jaxws.web.dev.tech/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TestWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInfo", targetNamespace = "http://jaxws.web.dev.tech/", className = "tech.dev.web.jaxws.GetInfo")
    @ResponseWrapper(localName = "getInfoResponse", targetNamespace = "http://jaxws.web.dev.tech/", className = "tech.dev.web.jaxws.GetInfoResponse")
    @Action(input = "http://jaxws.web.dev.tech/TestWS/getInfoRequest", output = "http://jaxws.web.dev.tech/TestWS/getInfoResponse")
    public String getInfo(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
