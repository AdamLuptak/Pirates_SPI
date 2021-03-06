//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.01 at 04:28:28 PM CEST 
//


package score.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="current_params" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="current_request_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nested_exception" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="source_data_service"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="default_namespace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="data_service_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ds_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "currentParams",
    "currentRequestName",
    "nestedException",
    "sourceDataService",
    "dsCode"
})
@XmlRootElement(name = "DataServiceFault", namespace = "http://ws.wso2.org/dataservice")
public class DataServiceFault {

    @XmlElement(name = "current_params", namespace = "http://ws.wso2.org/dataservice", required = true)
    protected String currentParams;
    @XmlElement(name = "current_request_name", namespace = "http://ws.wso2.org/dataservice", required = true)
    protected String currentRequestName;
    @XmlElement(name = "nested_exception", namespace = "http://ws.wso2.org/dataservice", required = true)
    protected String nestedException;
    @XmlElement(name = "source_data_service", namespace = "http://ws.wso2.org/dataservice", required = true)
    protected DataServiceFault.SourceDataService sourceDataService;
    @XmlElement(name = "ds_code", namespace = "http://ws.wso2.org/dataservice", required = true)
    protected String dsCode;

    /**
     * Gets the value of the currentParams property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentParams() {
        return currentParams;
    }

    /**
     * Sets the value of the currentParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentParams(String value) {
        this.currentParams = value;
    }

    /**
     * Gets the value of the currentRequestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentRequestName() {
        return currentRequestName;
    }

    /**
     * Sets the value of the currentRequestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentRequestName(String value) {
        this.currentRequestName = value;
    }

    /**
     * Gets the value of the nestedException property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNestedException() {
        return nestedException;
    }

    /**
     * Sets the value of the nestedException property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNestedException(String value) {
        this.nestedException = value;
    }

    /**
     * Gets the value of the sourceDataService property.
     * 
     * @return
     *     possible object is
     *     {@link DataServiceFault.SourceDataService }
     *     
     */
    public DataServiceFault.SourceDataService getSourceDataService() {
        return sourceDataService;
    }

    /**
     * Sets the value of the sourceDataService property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataServiceFault.SourceDataService }
     *     
     */
    public void setSourceDataService(DataServiceFault.SourceDataService value) {
        this.sourceDataService = value;
    }

    /**
     * Gets the value of the dsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsCode() {
        return dsCode;
    }

    /**
     * Sets the value of the dsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsCode(String value) {
        this.dsCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="default_namespace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="data_service_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "location",
        "defaultNamespace",
        "description",
        "dataServiceName"
    })
    public static class SourceDataService {

        @XmlElement(namespace = "http://ws.wso2.org/dataservice", required = true)
        protected String location;
        @XmlElement(name = "default_namespace", namespace = "http://ws.wso2.org/dataservice", required = true)
        protected String defaultNamespace;
        @XmlElement(namespace = "http://ws.wso2.org/dataservice", required = true)
        protected String description;
        @XmlElement(name = "data_service_name", namespace = "http://ws.wso2.org/dataservice", required = true)
        protected String dataServiceName;

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Gets the value of the defaultNamespace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultNamespace() {
            return defaultNamespace;
        }

        /**
         * Sets the value of the defaultNamespace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultNamespace(String value) {
            this.defaultNamespace = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the dataServiceName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataServiceName() {
            return dataServiceName;
        }

        /**
         * Sets the value of the dataServiceName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataServiceName(String value) {
            this.dataServiceName = value;
        }

    }

}
