
package com.jemmyee.core.WebService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Parking", targetNamespace = "http://park.webservice.ehl.com", wsdlLocation = "http://whtcjk.zx.whjg.gov.cn:8084/EHL_Parkinglot_Service/services/Parking?wsdl")
public class Parking
    extends Service
{

    private final static URL PARKING_WSDL_LOCATION;
    private final static WebServiceException PARKING_EXCEPTION;
    private final static QName PARKING_QNAME = new QName("http://park.webservice.ehl.com", "Parking");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://whtcjk.zx.whjg.gov.cn:8084/EHL_Parkinglot_Service/services/Parking?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARKING_WSDL_LOCATION = url;
        PARKING_EXCEPTION = e;
    }

    public Parking() {
        super(__getWsdlLocation(), PARKING_QNAME);
    }

    public Parking(WebServiceFeature... features) {
        super(__getWsdlLocation(), PARKING_QNAME, features);
    }

    public Parking(URL wsdlLocation) {
        super(wsdlLocation, PARKING_QNAME);
    }

    public Parking(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PARKING_QNAME, features);
    }

    public Parking(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Parking(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ParkingPortType
     */
    @WebEndpoint(name = "ParkingHttpPort")
    public ParkingPortType getParkingHttpPort() {
        return super.getPort(new QName("http://park.webservice.ehl.com", "ParkingHttpPort"), ParkingPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ParkingPortType
     */
    @WebEndpoint(name = "ParkingHttpPort")
    public ParkingPortType getParkingHttpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://park.webservice.ehl.com", "ParkingHttpPort"), ParkingPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PARKING_EXCEPTION!= null) {
            throw PARKING_EXCEPTION;
        }
        return PARKING_WSDL_LOCATION;
    }

}
