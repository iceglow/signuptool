
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bskalaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bskalaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bskala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="engben" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="not" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="svben" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bskalaVO", propOrder = {
    "bskala",
    "engben",
    "not",
    "svben"
})
public class BskalaVO {

    protected String bskala;
    protected String engben;
    protected int not;
    protected String svben;

    /**
     * Gets the value of the bskala property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBskala() {
        return bskala;
    }

    /**
     * Sets the value of the bskala property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBskala(String value) {
        this.bskala = value;
    }

    /**
     * Gets the value of the engben property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEngben() {
        return engben;
    }

    /**
     * Sets the value of the engben property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEngben(String value) {
        this.engben = value;
    }

    /**
     * Gets the value of the not property.
     * 
     */
    public int getNot() {
        return not;
    }

    /**
     * Sets the value of the not property.
     * 
     */
    public void setNot(int value) {
        this.not = value;
    }

    /**
     * Gets the value of the svben property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvben() {
        return svben;
    }

    /**
     * Sets the value of the svben property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvben(String value) {
        this.svben = value;
    }

}
