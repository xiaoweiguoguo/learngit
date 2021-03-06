
package com.jemmyee.core.WebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ParkingPortType", targetNamespace = "http://park.webservice.ehl.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ParkingPortType  {


    /**
     * 
     * @param xmlString
     * @param xtlb
     * @param jkxlh
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Parkinginfo")
    @WebResult(name = "out", targetNamespace = "http://park.webservice.ehl.com")
    @RequestWrapper(localName = "Parkinginfo", targetNamespace = "http://park.webservice.ehl.com", className = "com.demo.client.Parkinginfo")
    @ResponseWrapper(localName = "ParkinginfoResponse", targetNamespace = "http://park.webservice.ehl.com", className = "com.demo.client.ParkinginfoResponse")
    public String parkinginfo(
            @WebParam(name = "xtlb", targetNamespace = "http://park.webservice.ehl.com")
                    String xtlb,
            @WebParam(name = "jkxlh", targetNamespace = "http://park.webservice.ehl.com")
                    String jkxlh,
            @WebParam(name = "XmlString", targetNamespace = "http://park.webservice.ehl.com")
                    String xmlString);
}
