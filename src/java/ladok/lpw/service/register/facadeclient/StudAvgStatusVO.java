
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studAvgStatusVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studAvgStatusVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="avgstatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="messages" type="{http://facadeclient.register.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orsak" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "studAvgStatusVO", propOrder = {
    "avgstatus",
    "messages",
    "orsak",
    "termin",
    "valid"
})
public class StudAvgStatusVO {

    protected boolean avgstatus;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected int orsak;
    protected String termin;
    protected boolean valid;

    /**
     * Gets the value of the avgstatus property.
     * 
     */
    public boolean isAvgstatus() {
        return avgstatus;
    }

    /**
     * Sets the value of the avgstatus property.
     * 
     */
    public void setAvgstatus(boolean value) {
        this.avgstatus = value;
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
     * Gets the value of the orsak property.
     * 
     */
    public int getOrsak() {
        return orsak;
    }

    /**
     * Sets the value of the orsak property.
     * 
     */
    public void setOrsak(int value) {
        this.orsak = value;
    }

    /**
     * Gets the value of the termin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermin() {
        return termin;
    }

    /**
     * Sets the value of the termin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermin(String value) {
        this.termin = value;
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
