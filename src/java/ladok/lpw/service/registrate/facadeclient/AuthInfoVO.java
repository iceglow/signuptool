
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authInfoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authInfoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticket" type="{http://facadeclient.registrate.service.lpw.ladok/}ticketVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authInfoVO", propOrder = {
    "authRole",
    "authServer",
    "authType",
    "caller",
    "ticket"
})
public class AuthInfoVO {

    protected String authRole;
    protected String authServer;
    protected String authType;
    protected String caller;
    protected TicketVO ticket;

    /**
     * Gets the value of the authRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthRole() {
        return authRole;
    }

    /**
     * Sets the value of the authRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthRole(String value) {
        this.authRole = value;
    }

    /**
     * Gets the value of the authServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthServer() {
        return authServer;
    }

    /**
     * Sets the value of the authServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthServer(String value) {
        this.authServer = value;
    }

    /**
     * Gets the value of the authType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Sets the value of the authType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthType(String value) {
        this.authType = value;
    }

    /**
     * Gets the value of the caller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaller() {
        return caller;
    }

    /**
     * Sets the value of the caller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaller(String value) {
        this.caller = value;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link TicketVO }
     *     
     */
    public TicketVO getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketVO }
     *     
     */
    public void setTicket(TicketVO value) {
        this.ticket = value;
    }

}
