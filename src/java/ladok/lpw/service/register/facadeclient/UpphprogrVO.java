
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for upphprogrVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="upphprogrVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diarienr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ffgRegAllowed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromTermin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromTerminWash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="garanteradPlats" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="program" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tomTermin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tomTerminWash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upphprogrVO", propOrder = {
    "benamne",
    "benamns",
    "diarienr",
    "ffgRegAllowed",
    "fromTermin",
    "fromTerminWash",
    "garanteradPlats",
    "program",
    "specification",
    "tomTermin",
    "tomTerminWash"
})
public class UpphprogrVO {

    protected String benamne;
    protected String benamns;
    protected String diarienr;
    protected String ffgRegAllowed;
    protected String fromTermin;
    protected String fromTerminWash;
    protected String garanteradPlats;
    protected String program;
    protected String specification;
    protected String tomTermin;
    protected String tomTerminWash;

    /**
     * Gets the value of the benamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamne() {
        return benamne;
    }

    /**
     * Sets the value of the benamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamne(String value) {
        this.benamne = value;
    }

    /**
     * Gets the value of the benamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamns() {
        return benamns;
    }

    /**
     * Sets the value of the benamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamns(String value) {
        this.benamns = value;
    }

    /**
     * Gets the value of the diarienr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiarienr() {
        return diarienr;
    }

    /**
     * Sets the value of the diarienr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiarienr(String value) {
        this.diarienr = value;
    }

    /**
     * Gets the value of the ffgRegAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFfgRegAllowed() {
        return ffgRegAllowed;
    }

    /**
     * Sets the value of the ffgRegAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFfgRegAllowed(String value) {
        this.ffgRegAllowed = value;
    }

    /**
     * Gets the value of the fromTermin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromTermin() {
        return fromTermin;
    }

    /**
     * Sets the value of the fromTermin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromTermin(String value) {
        this.fromTermin = value;
    }

    /**
     * Gets the value of the fromTerminWash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromTerminWash() {
        return fromTerminWash;
    }

    /**
     * Sets the value of the fromTerminWash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromTerminWash(String value) {
        this.fromTerminWash = value;
    }

    /**
     * Gets the value of the garanteradPlats property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGaranteradPlats() {
        return garanteradPlats;
    }

    /**
     * Sets the value of the garanteradPlats property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGaranteradPlats(String value) {
        this.garanteradPlats = value;
    }

    /**
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgram(String value) {
        this.program = value;
    }

    /**
     * Gets the value of the specification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecification(String value) {
        this.specification = value;
    }

    /**
     * Gets the value of the tomTermin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTomTermin() {
        return tomTermin;
    }

    /**
     * Sets the value of the tomTermin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTomTermin(String value) {
        this.tomTermin = value;
    }

    /**
     * Gets the value of the tomTerminWash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTomTerminWash() {
        return tomTerminWash;
    }

    /**
     * Sets the value of the tomTerminWash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTomTerminWash(String value) {
        this.tomTerminWash = value;
    }

}
