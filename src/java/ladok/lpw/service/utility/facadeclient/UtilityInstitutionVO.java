
package ladok.lpw.service.utility.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utilityInstitutionVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utilityInstitutionVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gatadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.utility.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utilityInstitutionVO", propOrder = {
    "benamn",
    "benamne",
    "gatadr",
    "kod",
    "messages",
    "ort",
    "postnr",
    "telefon",
    "valid"
})
public class UtilityInstitutionVO {

    protected String benamn;
    protected String benamne;
    protected String gatadr;
    protected String kod;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String ort;
    protected String postnr;
    protected String telefon;
    protected boolean valid;

    /**
     * Gets the value of the benamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamn() {
        return benamn;
    }

    /**
     * Sets the value of the benamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamn(String value) {
        this.benamn = value;
    }

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
     * Gets the value of the gatadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGatadr() {
        return gatadr;
    }

    /**
     * Sets the value of the gatadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGatadr(String value) {
        this.gatadr = value;
    }

    /**
     * Gets the value of the kod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKod() {
        return kod;
    }

    /**
     * Sets the value of the kod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKod(String value) {
        this.kod = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return this.messages;
    }

    /**
     * Gets the value of the ort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Sets the value of the ort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrt(String value) {
        this.ort = value;
    }

    /**
     * Gets the value of the postnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostnr() {
        return postnr;
    }

    /**
     * Sets the value of the postnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostnr(String value) {
        this.postnr = value;
    }

    /**
     * Gets the value of the telefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the value of the telefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefon(String value) {
        this.telefon = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the value of the valid property.
     * 
     */
    public void setValid(boolean value) {
        this.valid = value;
    }

}
