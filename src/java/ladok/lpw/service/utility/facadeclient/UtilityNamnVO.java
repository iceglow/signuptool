
package ladok.lpw.service.utility.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utilityNamnVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utilityNamnVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="avliden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gallrad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gallraddatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasnewpnr" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="igallrad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="igallraddatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inladok" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="messages" type="{http://facadeclient.utility.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tnamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "utilityNamnVO", propOrder = {
    "avliden",
    "enamn",
    "gallrad",
    "gallraddatum",
    "hasnewpnr",
    "igallrad",
    "igallraddatum",
    "inladok",
    "messages",
    "pnr",
    "tnamn",
    "valid"
})
public class UtilityNamnVO {

    protected boolean avliden;
    protected String enamn;
    protected boolean gallrad;
    protected String gallraddatum;
    protected boolean hasnewpnr;
    protected boolean igallrad;
    protected String igallraddatum;
    protected boolean inladok;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String pnr;
    protected String tnamn;
    protected boolean valid;

    /**
     * Gets the value of the avliden property.
     * 
     */
    public boolean isAvliden() {
        return avliden;
    }

    /**
     * Sets the value of the avliden property.
     * 
     */
    public void setAvliden(boolean value) {
        this.avliden = value;
    }

    /**
     * Gets the value of the enamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnamn() {
        return enamn;
    }

    /**
     * Sets the value of the enamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnamn(String value) {
        this.enamn = value;
    }

    /**
     * Gets the value of the gallrad property.
     * 
     */
    public boolean isGallrad() {
        return gallrad;
    }

    /**
     * Sets the value of the gallrad property.
     * 
     */
    public void setGallrad(boolean value) {
        this.gallrad = value;
    }

    /**
     * Gets the value of the gallraddatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGallraddatum() {
        return gallraddatum;
    }

    /**
     * Sets the value of the gallraddatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGallraddatum(String value) {
        this.gallraddatum = value;
    }

    /**
     * Gets the value of the hasnewpnr property.
     * 
     */
    public boolean isHasnewpnr() {
        return hasnewpnr;
    }

    /**
     * Sets the value of the hasnewpnr property.
     * 
     */
    public void setHasnewpnr(boolean value) {
        this.hasnewpnr = value;
    }

    /**
     * Gets the value of the igallrad property.
     * 
     */
    public boolean isIgallrad() {
        return igallrad;
    }

    /**
     * Sets the value of the igallrad property.
     * 
     */
    public void setIgallrad(boolean value) {
        this.igallrad = value;
    }

    /**
     * Gets the value of the igallraddatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIgallraddatum() {
        return igallraddatum;
    }

    /**
     * Sets the value of the igallraddatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIgallraddatum(String value) {
        this.igallraddatum = value;
    }

    /**
     * Gets the value of the inladok property.
     * 
     */
    public boolean isInladok() {
        return inladok;
    }

    /**
     * Sets the value of the inladok property.
     * 
     */
    public void setInladok(boolean value) {
        this.inladok = value;
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
     * Gets the value of the pnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnr() {
        return pnr;
    }

    /**
     * Sets the value of the pnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnr(String value) {
        this.pnr = value;
    }

    /**
     * Gets the value of the tnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTnamn() {
        return tnamn;
    }

    /**
     * Sets the value of the tnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTnamn(String value) {
        this.tnamn = value;
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
