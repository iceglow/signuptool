
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bksInfoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bksInfoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bksRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bksServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bksSublevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bksInfoVO", propOrder = {
    "bksRole",
    "bksServer",
    "bksSublevel"
})
public class BksInfoVO {

    protected String bksRole;
    protected String bksServer;
    protected String bksSublevel;

    /**
     * Gets the value of the bksRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBksRole() {
        return bksRole;
    }

    /**
     * Sets the value of the bksRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBksRole(String value) {
        this.bksRole = value;
    }

    /**
     * Gets the value of the bksServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBksServer() {
        return bksServer;
    }

    /**
     * Sets the value of the bksServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBksServer(String value) {
        this.bksServer = value;
    }

    /**
     * Gets the value of the bksSublevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBksSublevel() {
        return bksSublevel;
    }

    /**
     * Sets the value of the bksSublevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBksSublevel(String value) {
        this.bksSublevel = value;
    }

}
