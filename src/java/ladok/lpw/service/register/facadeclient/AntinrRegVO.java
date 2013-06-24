
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for antinrRegVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="antinrRegVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="avbrdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avbrdnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "antinrRegVO", propOrder = {
    "avbrdat",
    "avbrdnr",
    "benamne",
    "benamns",
    "inr",
    "konvert",
    "poang"
})
public class AntinrRegVO {

    protected String avbrdat;
    protected String avbrdnr;
    protected String benamne;
    protected String benamns;
    protected String inr;
    protected String konvert;
    protected String poang;

    /**
     * Gets the value of the avbrdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrdat() {
        return avbrdat;
    }

    /**
     * Sets the value of the avbrdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrdat(String value) {
        this.avbrdat = value;
    }

    /**
     * Gets the value of the avbrdnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrdnr() {
        return avbrdnr;
    }

    /**
     * Sets the value of the avbrdnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrdnr(String value) {
        this.avbrdnr = value;
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
     * Gets the value of the inr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInr() {
        return inr;
    }

    /**
     * Sets the value of the inr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInr(String value) {
        this.inr = value;
    }

    /**
     * Gets the value of the konvert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonvert() {
        return konvert;
    }

    /**
     * Sets the value of the konvert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonvert(String value) {
        this.konvert = value;
    }

    /**
     * Gets the value of the poang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoang() {
        return poang;
    }

    /**
     * Sets the value of the poang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoang(String value) {
        this.poang = value;
    }

}
