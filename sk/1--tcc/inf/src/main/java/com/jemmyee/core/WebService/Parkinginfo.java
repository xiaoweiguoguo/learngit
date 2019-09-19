
package com.jemmyee.core.WebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xtlb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jkxlh" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="XmlString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "xtlb",
    "jkxlh",
    "xmlString"
})
@XmlRootElement(name = "Parkinginfo")
public class Parkinginfo {

    @XmlElement(required = true, nillable = true)
    protected String xtlb;
    @XmlElement(required = true, nillable = true)
    protected String jkxlh;
    @XmlElement(name = "XmlString", required = true, nillable = true)
    protected String xmlString;

    /**
     * ��ȡxtlb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXtlb() {
        return xtlb;
    }

    /**
     * ����xtlb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXtlb(String value) {
        this.xtlb = value;
    }

    /**
     * ��ȡjkxlh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJkxlh() {
        return jkxlh;
    }

    /**
     * ����jkxlh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJkxlh(String value) {
        this.jkxlh = value;
    }

    /**
     * ��ȡxmlString���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlString() {
        return xmlString;
    }

    /**
     * ����xmlString���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlString(String value) {
        this.xmlString = value;
    }

}
