
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for larareVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="larareVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "larareVO", propOrder = {
    "kod",
    "namn",
    "titel"
})
public class LarareVO {

    protected String kod;
    protected String namn;
    protected String titel;

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
     * Gets the value of the namn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamn() {
        return namn;
    }

    /**
     * Sets the value of the namn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamn(String value) {
        this.namn = value;
    }

    /**
     * Gets the value of the titel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Sets the value of the titel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitel(String value) {
        this.titel = value;
    }

}
