
package ladok.lpw.service.changeaddress.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gatadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inldat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="land" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.changeaddress.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tomdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "addressVO", propOrder = {
    "coadr",
    "fromdat",
    "gatadr",
    "inldat",
    "land",
    "messages",
    "ort",
    "postnr",
    "tomdat",
    "valid"
})
public class AddressVO {

    protected String coadr;
    protected String fromdat;
    protected String gatadr;
    protected String inldat;
    protected String land;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String ort;
    protected String postnr;
    protected String tomdat;
    protected boolean valid;

    /**
     * Gets the value of the coadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoadr() {
        return coadr;
    }

    /**
     * Sets the value of the coadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoadr(String value) {
        this.coadr = value;
    }

    /**
     * Gets the value of the fromdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromdat() {
        return fromdat;
    }

    /**
     * Sets the value of the fromdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromdat(String value) {
        this.fromdat = value;
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
     * Gets the value of the land property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLand() {
        return land;
    }

    /**
     * Sets the value of the land property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLand(String value) {
        this.land = value;
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
     * Gets the value of the tomdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTomdat() {
        return tomdat;
    }

    /**
     * Sets the value of the tomdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTomdat(String value) {
        this.tomdat = value;
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
