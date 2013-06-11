
package ladok.lpw.service.changeaddress.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeAddressVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changeAddressVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annanid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etabldat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etablort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inldat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limitedAddr" type="{http://facadeclient.changeaddress.service.lpw.ladok/}addressVO" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.changeaddress.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="permanentAddr" type="{http://facadeclient.changeaddress.service.lpw.ladok/}addressVO" minOccurs="0"/>
 *         &lt;element name="sekel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telekom" type="{http://facadeclient.changeaddress.service.lpw.ladok/}telekomVO" minOccurs="0"/>
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
@XmlType(name = "changeAddressVO", propOrder = {
    "annanid",
    "enamn",
    "etabldat",
    "etablort",
    "inldat",
    "konto",
    "limitedAddr",
    "messages",
    "permanentAddr",
    "sekel",
    "telekom",
    "tnamn",
    "valid"
})
public class ChangeAddressVO {

    protected String annanid;
    protected String enamn;
    protected String etabldat;
    protected String etablort;
    protected String inldat;
    protected String konto;
    protected AddressVO limitedAddr;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected AddressVO permanentAddr;
    protected String sekel;
    protected TelekomVO telekom;
    protected String tnamn;
    protected boolean valid;

    /**
     * Gets the value of the annanid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnanid() {
        return annanid;
    }

    /**
     * Sets the value of the annanid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnanid(String value) {
        this.annanid = value;
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
     * Gets the value of the etabldat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtabldat() {
        return etabldat;
    }

    /**
     * Sets the value of the etabldat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtabldat(String value) {
        this.etabldat = value;
    }

    /**
     * Gets the value of the etablort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtablort() {
        return etablort;
    }

    /**
     * Sets the value of the etablort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtablort(String value) {
        this.etablort = value;
    }

    /**
     * Gets the value of the inldat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInldat() {
        return inldat;
    }

    /**
     * Sets the value of the inldat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInldat(String value) {
        this.inldat = value;
    }

    /**
     * Gets the value of the konto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonto() {
        return konto;
    }

    /**
     * Sets the value of the konto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonto(String value) {
        this.konto = value;
    }

    /**
     * Gets the value of the limitedAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressVO }
     *     
     */
    public AddressVO getLimitedAddr() {
        return limitedAddr;
    }

    /**
     * Sets the value of the limitedAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressVO }
     *     
     */
    public void setLimitedAddr(AddressVO value) {
        this.limitedAddr = value;
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
     * Gets the value of the permanentAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressVO }
     *     
     */
    public AddressVO getPermanentAddr() {
        return permanentAddr;
    }

    /**
     * Sets the value of the permanentAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressVO }
     *     
     */
    public void setPermanentAddr(AddressVO value) {
        this.permanentAddr = value;
    }

    /**
     * Gets the value of the sekel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSekel() {
        return sekel;
    }

    /**
     * Sets the value of the sekel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSekel(String value) {
        this.sekel = value;
    }

    /**
     * Gets the value of the telekom property.
     * 
     * @return
     *     possible object is
     *     {@link TelekomVO }
     *     
     */
    public TelekomVO getTelekom() {
        return telekom;
    }

    /**
     * Sets the value of the telekom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelekomVO }
     *     
     */
    public void setTelekom(TelekomVO value) {
        this.telekom = value;
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
