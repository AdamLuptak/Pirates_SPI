//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.01 at 12:07:21 PM CEST 
//


package io.spring.guides.gs_producing_web_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultValue" type="{http://spring.io/guides/gs-producing-web-service}resultValueType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://spring.io/guides/gs-producing-web-service}functionRef use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultType", propOrder = {
    "resultValue"
})
public class ResultType {

    protected List<ResultValueType> resultValue;
    @XmlAttribute(name = "functionRef", namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String functionRef;

    /**
     * Gets the value of the resultValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultValueType }
     * 
     * 
     */
    public List<ResultValueType> getResultValue() {
        if (resultValue == null) {
            resultValue = new ArrayList<ResultValueType>();
        }
        return this.resultValue;
    }

    /**
     * Gets the value of the functionRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionRef() {
        return functionRef;
    }

    /**
     * Sets the value of the functionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionRef(String value) {
        this.functionRef = value;
    }

}
